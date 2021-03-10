package wz.life.reflection.day01.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * ava的反射API提供的Method对象封装了方法的所有信息：
 *
 * 通过Class实例的方法可以获取Method实例：getMethod()，getMethods()，getDeclaredMethod()，getDeclaredMethods()；
 *
 * 通过Method实例可以获取方法信息：getName()，getReturnType()，getParameterTypes()，getModifiers()；
 *
 * 通过Method实例可以调用某个对象的方法：Object invoke(Object instance, Object... parameters)；
 *
 * 通过设置setAccessible(true)来访问非public方法；
 *
 * 通过反射调用方法时，仍然遵循多态原则。
 *
 * @DESCRIPTION 调用方法
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/4 11:53 下午
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        我们已经能通过Class实例获取所有Field对象，同样的，可以通过Class实例获取所有Method信息。Class类提供了以下几个方法来获取Method：
//
//        Method getMethod(name, Class...)：获取某个public的Method（包括父类）
//        Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
//        Method[] getMethods()：获取所有public的Method（包括父类）
//        Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
//        我们来看一下示例代码：

        Class studentClass = Student.class;
        //获取public方法getScore，参数为String
        System.out.println(studentClass.getMethod("getScore",String.class));
        //获取继承的public方法getName，无参数
        System.out.println(studentClass.getMethod("getName"));
        //获取private方法getGrade，参数为int
        System.out.println(studentClass.getDeclaredMethod("getGrade",int.class));
//        public int wz.life.reflection.day01.method.Student.getScore(java.lang.String)
//        public java.lang.String wz.life.reflection.day01.method.Person.getName()
//        private int wz.life.reflection.day01.method.Student.getGrade(int)

//        一个Method对象包含一个方法的所有信息：
//
//        getName()：返回方法名称，例如："getScore"；
//        getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
//        getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
//        getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。


        /**调用方法*/
        String s = "Hello world";
        String r = s.substring(6); // "world"
        Class str = String.class;
        Method method = str.getMethod("substring",int.class,int.class);
        // 在s对象上调用该方法并获取结果:
        String newR = (String) method.invoke(s,2,6);
        System.out.println(newR);

//        注意到substring()有两个重载方法，我们获取的是String substring(int)这个方法。思考一下如何获取String substring(int, int)方法。
//
//        对Method实例调用invoke就相当于调用该方法，invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错。

//        如果获取到的Method表示一个静态方法，调用静态方法时，
//        由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null。
//        我们以Integer.parseInt(String)为例：

        // 获取Integer.parseInt(String)方法，参数为String:
        Method m = Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = (Integer)m.invoke(null,"12345");
        System.out.println(n);

//        调用非public方法
//        和Field类似，对于非public方法，我们虽然可以通过Class.getDeclaredMethod()获取该方法实例，但直接对其调用将得到一个IllegalAccessException。为了调用非public方法，我们通过Method.setAccessible(true)允许其调用：

        Person p = new Person();
        Method mm = p.getClass().getDeclaredMethod("setName", String.class);
        mm.setAccessible(true);
        mm.invoke(p,"122");

        System.out.println(p.name);

//        此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，
//        那么它会根据规则进行检查，有可能阻止setAccessible(true)。
//        例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全。

        /**多态*/
//        我们来考察这样一种情况：一个Person类定义了hello()方法，
//        并且它的子类Student也覆写了hello()方法，
//        那么，从Person.class获取的Method，
//        作用于Student实例时，调用的方法到底是哪个？

        Method mmm = Person.class.getMethod("hello");
        mmm.invoke(new Student());

        //运行上述代码，发现打印出的是Student:hello，因此，使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。上述的反射代码：

//        Method m = Person.class.getMethod("hello");
//        m.invoke(new Student());
//        实际上相当于：
//        Person p = new Student();
//        p.hello();




    }
}

class Student extends Person{
    public int getScore(String type){
        return 99;
    }

    private int getGrade(int year){
        return 1;
    }
    @Override
    public void hello() {
        System.out.println("Student:hello");
    }

}

class Person{
    public String getName(){
        return "Person";
    }

    String name;
    private void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Person:hello");
    }
}
