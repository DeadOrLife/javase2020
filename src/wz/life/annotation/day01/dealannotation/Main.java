package wz.life.annotation.day01.dealannotation;

import java.lang.reflect.Field;

/**
 *
 * 可以在运行期通过反射读取RUNTIME类型的注解，注意千万不要漏写@Retention(RetentionPolicy.RUNTIME)，否则运行期无法读取到该注解。
 *
 * 可以通过程序处理注解来实现相应的功能：
 *
 * 对JavaBean的属性值按规则进行检查；
 * JUnit会自动运行@Test标记的测试方法。
 * @DESCRIPTION 处理注解
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/6 12:11 上午
 */
public class Main {


    public static void main(String[] args) {
//        Java的注解本身对代码逻辑没有任何影响。根据@Retention的配置：
//
//        SOURCE类型的注解在编译期就被丢掉了；
//        CLASS类型的注解仅保存在class文件中，它们不会被加载进JVM；
//        RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。
//        如何使用注解完全由工具决定。SOURCE类型的注解主要由编译器使用，因此我们一般只使用，不编写。CLASS类型的注解主要由底层工具库使用，涉及到class的加载，一般我们很少用到。只有RUNTIME类型的注解不但要使用，还经常需要编写。
//
//        因此，我们只讨论如何读取RUNTIME类型的注解。
//
//        因为注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation，因此，读取注解，需要使用反射API。
//
//        Java提供的使用反射API读取Annotation的方法包括：
//
//        判断某个注解是否存在于Class、Field、Method或Constructor：
//
//        Class.isAnnotationPresent(Class)
//        Field.isAnnotationPresent(Class)
//        Method.isAnnotationPresent(Class)
//        Constructor.isAnnotationPresent(Class)

        // 判断@Report是否存在于Person类:
//        Person.class.isAnnotationPresent(Report.class);


//        使用反射API读取Annotation：
//
//        Class.getAnnotation(Class)
//        Field.getAnnotation(Class)
//        Method.getAnnotation(Class)
//        Constructor.getAnnotation(Class)

        // 获取Person定义的@Report注解:
//        Report report = Person.class.getAnnotation(Report.class);
//        int type = report.type();
//        String level = report.level();


//        使用反射API读取Annotation有两种方法。方法一是先判断Annotation是否存在，如果存在，就直接读取：
//        Class cls = Person.class;
//        if (cls.isAnnotationPresent(Report.class)) {
//            Report report = cls.getAnnotation(Report.class);
//    ...
//        }

//        第二种方法是直接读取Annotation，如果Annotation不存在，将返回null：
//        Class cls = Person.class;
//        Report report = cls.getAnnotation(Report.class);
//        if (report != null) {
//   ...
//        }

//        读取方法、字段和构造方法的Annotation和Class类似。但要读取方法参数的Annotation就比较麻烦一点，因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，所以，一次获取方法参数的所有注解就必须用一个二维数组来表示。例如，对于以下方法定义的注解：

//        要读取方法参数的注解，我们先用反射获取Method实例，然后读取方法参数的所有注解：
//
//// 获取Method实例:
//        Method m = ...
//// 获取所有参数的Annotation:
//        Annotation[][] annos = m.getParameterAnnotations();
//// 第一个参数（索引为0）的所有Annotation:
//        Annotation[] annosOfName = annos[0];
//        for (Annotation anno : annosOfName) {
//            if (anno instanceof Range) { // @Range注解
//                Range r = (Range) anno;
//            }
//            if (anno instanceof NotNull) { // @NotNull注解
//                NotNull n = (NotNull) anno;
//            }
//        }


        /**使用注解*/
//        注解如何使用，完全由程序自己决定。例如，JUnit是一个测试框架，它会自动运行所有标记为@Test的方法。
//
//        我们来看一个@Range注解，我们希望用它来定义一个String字段的规则：字段长度满足@Range的参数定义：

        Person person = new Person();
        person.name="111";

        try {
            check(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        这样一来，我们通过@Range注解，配合check()方法，就可以完成Person实例的检查。注意检查逻辑完全是我们自己编写的，JVM不会自动给注解添加任何额外的逻辑。


    }

   static void check(Person person) throws IllegalAccessException {
        //利用反射获取 Person 里面的所有字段
        Class cls = Person.class;
        Field[] fields = cls.getFields();
        for (Field f : fields){
            //判断字段上面是否存在Range注解
            Range range = f.getAnnotation(Range.class);
            if (range != null){
                f.setAccessible(true);
                Object value = f.get(person);
                if (value instanceof String){
                    String s = (String)value;
                    if (s.length() < range.min() || s.length() > range.max()){
                        throw new IllegalArgumentException("Invalid field: " + f.getName());
                    }
                }
                if (value instanceof Integer){
                    Integer s = (Integer)value;
                    if (s < range.min() || s > range.max()){
                        throw new IllegalArgumentException("Invalid field: " + f.getName());
                    }
                }

            }
        }

    }
}
