package wz.life.reflection.day01.clazz;

/**
 *
 * JVM为每个加载的class及interface创建了对应的Class实例来保存class及interface的所有信息；
 *
 * 获取一个class对应的Class实例后，就可以获取该class的所有信息；
 *
 * 通过Class实例获取class信息的方法称为反射（Reflection）；
 *
 * JVM总是动态加载class，可以在运行期根据条件来控制加载class。
 *
 * @DESCRIPTION class类
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/3 10:57 上午
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        /*
        * 除了int等基本类型外，Java的其他类型全部都是class（包括interface）。例如：
            String
            Object
            Runnable
            Exception
            ...
            仔细思考，我们可以得出结论：class（包括interface）的本质是数据类型（Type）。无继承关系的数据类型无法赋值：
        * */

        Number nn = new Double(123.456);// ok
//        String s = new Double(123.456); // compile error!

//        而class是由JVM在执行过程中动态加载的。JVM在第一次读取到一种class类型时，将其加载进内存。
//
//        每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。
//        注意：这里的Class类型是一个名叫Class的class。它长这样：

//        public final class Class {
//            private Class() {}
//        }

//        以String类为例，当JVM加载String类时，它首先读取String.class文件到内存，然后，为String类创建一个Class实例并关联起来：

//        Class cls = new Class(String);

//        这个Class实例是JVM内部创建的，如果我们查看JDK源码，可以发现Class类的构造方法是private，只有JVM能创建Class实例，我们自己的Java程序是无法创建Class实例的。

//        由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息。

//        这种通过Class实例获取class信息的方法称为反射（Reflection）。

//        如何获取一个class的Class实例？有三个方法：

//        方法一：直接通过一个class的静态变量class获取：
        Class cls = String.class;

//        方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
        String s = "Hello";
        Class cls2 = s.getClass();

//        方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls3 = Class.forName("java.lang.String");


//        因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例：


        System.out.println(cls==cls2);


//        注意一下Class实例比较和instanceof的差别：

        Integer n = new Integer(123);

        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类

        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
//        boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class

//        用instanceof不但匹配指定类型，还匹配指定类型的子类。而用==判断class实例可以精确地判断数据类型，但不能作子类型比较。
//
//        通常情况下，我们应该用instanceof判断数据类型，因为面向抽象编程的时候，我们不关心具体的子类型。只有在需要精确判断一个类型是不是某个class的时候，我们才使用==判断class实例。
//
//        因为反射的目的是为了获得某个实例的信息。因此，当我们拿到某个Object实例时，我们可以通过反射获取该Object的class信息：

        printClassInfo("".getClass());
        System.out.println("////////");
        printClassInfo(Runnable.class);
        System.out.println("////////");
        printClassInfo(java.time.Month.class);
        System.out.println("////////");
        printClassInfo(String[].class);
        System.out.println("////////");
        printClassInfo(int.class);


//        注意到数组（例如String[]）也是一种Class，而且不同于String.class，它的类名是[Ljava.lang.String。此外，JVM为每一种基本类型如int也创建了Class，通过int.class访问。
//
//        如果获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：

// 获取String的Class实例:
        Class cl = String.class;
// 创建一个String实例:
        String str = (String) cl.newInstance();

        //上述代码相当于new String()。通过Class.newInstance()可以创建类实例，它的局限是：
        // 只能调用public的无参数构造方法。
        // 带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。


        //动态加载
        //JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载。例如：

        if (args.length > 0) {
            create(args[0]);
        }

//        当执行Main.java时，由于用到了Main，因此，JVM首先会把Main.class加载到内存。然而，并不会加载Person.class，除非程序执行到create()方法，JVM发现需要加载Person类时，才会首次加载Person.class。如果没有执行create()方法，那么Person.class根本就不会被加载。

//        这就是JVM动态加载class的特性。

//        动态加载class的特性对于Java程序非常重要。利用JVM动态加载class的特性，我们才能在运行期根据条件加载不同的实现类。例如，Commons Logging总是优先使用Log4j，只有当Log4j不存在时，才使用JDK的logging。利用JVM动态加载特性，大致的实现代码如下：

        /*
        * // Commons Logging优先使用Log4j:
            LogFactory factory = null;
            if (isClassPresent("org.apache.logging.log4j.Logger")) {
                factory = createLog4j();
            } else {
                factory = createJdkLog();
            }

            boolean isClassPresent(String name) {
                try {
                    Class.forName(name);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        * */
//        这就是为什么我们只需要把Log4j的jar包放到classpath中，Commons Logging就会自动使用Log4j的原因。





    }


    static void printClassInfo(Class cls){
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        //是否原始类型
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    static void create(String name) {
        Person p = new Person(name);
    }

}
class Person{

    String name;
    public Person(String name){
        this.name = name;
    }
}
