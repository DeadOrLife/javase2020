package wz.life.reflection.day01.filed;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *
 * Java的反射API提供的Field类封装了字段的所有信息：
 *
 * 通过Class实例的方法可以获取Field实例：getField()，getFields()，getDeclaredField()，getDeclaredFields()；
 *
 * 通过Field实例可以获取字段信息：getName()，getType()，getModifiers()；
 *
 * 通过Field实例可以读取或设置某个对象的字段，如果存在访问限制，要首先调用setAccessible(true)来访问非public字段。
 *
 * 通过反射读写字段是一种非常规方法，它会破坏对象的封装。
 * @DESCRIPTION 访问字段
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/4 9:31 下午
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

//        对任意的一个Object实例，只要我们获取了它的Class，就可以获取它的一切信息。
//
//        我们先看看如何通过Class实例获取字段信息。Class类提供了以下几个方法来获取字段：
//
//        Field getField(name)：根据字段名获取某个public的field（包括父类）
//        Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
//        Field[] getFields()：获取所有public的field（包括父类）
//        Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
//        我们来看一下示例代码：

        Class studentClass = Student.class;
        //获取public字段
        System.out.println(studentClass.getField("score"));
        //获取继承public字段"name"
        System.out.println(studentClass.getField("name"));
        //获取private字段
        System.out.println(studentClass.getDeclaredField("grade"));

//        public int wz.life.reflection.day01.filed.Student.score
//        public java.lang.String wz.life.reflection.day01.filed.Person.name
//        private int wz.life.reflection.day01.filed.Student.grade
//        一个Field对象包含了一个字段的所有信息：
//
//        getName()：返回字段名称，例如，"name"；
//        getType()：返回字段类型，也是一个Class实例，例如，String.class；
//        getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
//        以String类的value字段为例，它的定义是：


        Field f = String.class.getDeclaredField("value");
        f.getName(); // "value"
        f.getType(); // class [C 表示char[]类型
        System.out.println(f.getName());
        System.out.println(f.getType());
        int m = f.getModifiers();
        Modifier.isFinal(m); // true
        Modifier.isPublic(m); // false
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isProtected(m));
        System.out.println(Modifier.isPrivate(m));
        System.out.println(Modifier.isStatic(m));


        /**获取字段值*/
//        利用反射拿到字段的一个Field实例只是第一步，我们还可以拿到一个实例对应的该字段的值。
//
//        例如，对于一个Person实例，我们可以先拿到name字段对应的Field，再获取这个实例的name字段的值：
        Object person = new Person("XIAO MING");
        Class c = person.getClass();
        Field f1 = c.getDeclaredField("name");
        //不管这个字段是不是public 一律允许访问
        f.setAccessible(true);
        Object value = f1.get(person);
        System.out.println(value);

//        上述代码先获取Class实例，再获取Field实例，然后，用Field.get(Object)获取指定实例的指定字段的值。

//        运行代码，如果不出意外，会得到一个IllegalAccessException，这是因为name被定义为一个private字段，正常情况下，Main类无法访问Person类的private字段。要修复错误，可以将private改为public，或者，在调用Object value = f.get(p);前，先写一句：
//        调用Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问。

//        可以试着加上上述语句，再运行代码，就可以打印出private字段的值。
//
//        有童鞋会问：如果使用反射可以获取private字段的值，那么类的封装还有什么意义？
//
//        答案是正常情况下，我们总是通过p.name来访问Person的name字段，编译器会根据public、protected和private决定是否允许访问字段，这样就达到了数据封装的目的。
//
//        而反射是一种非常规的用法，使用反射，首先代码非常繁琐，其次，它更多地是给工具或者底层框架来使用，目的是在不知道目标实例任何信息的情况下，获取特定字段的值。
//
//        此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，
//        那么它会根据规则进行检查，有可能阻止setAccessible(true)。
//        例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，
//        这样可以保证JVM核心库的安全。


        /**设置字段值*/

//        通过Field实例既然可以获取到指定实例的字段值，自然也可以设置字段的值。
//
//        设置字段值是通过Field.set(Object, Object)实现的，其中第一个Object参数是指定的实例，第二个Object参数是待修改的值。示例代码如下：

        f1.set(person,"xiao hong");
        System.out.println(f1.get(person));

//        运行上述代码，打印的name字段从Xiao Ming变成了Xiao Hong，说明通过反射可以直接修改字段的值。

    }
}

class Student extends Person{
    public int score;
    private int grade;
}
class Person{
    public String name;
    public Person(){}

    public Person(String name){
        this.name = name;
    }
}
