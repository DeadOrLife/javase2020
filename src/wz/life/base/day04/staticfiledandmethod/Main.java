package wz.life.base.day04.staticfiledandmethod;

/**
 *
 * 静态字段属于所有实例“共享”的字段，实际上是属于class的字段；
 *
 * 调用静态方法不需要实例，无法访问this，但可以访问静态字段和其他静态方法；
 *
 * 静态方法常用于工具类和辅助方法。
 *
 * @DESCRIPTION 静态字段和静态方法
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/26 11:16 下午
 */
public class Main {

    public static void main(String[] args) {
        //对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，原因是静态字段并不属于实例：
        //虽然实例可以访问静态字段，但是它们指向的其实都是Person class的静态字段。所以，所有实例共享一个静态字段。
        //因此，不推荐用实例变量.静态字段去访问静态字段，因为在Java程序中，实例对象并没有静态字段。在代码中，实例对象能访问静态字段只是因为编译器可以根据实例类型自动转换为类名.静态字段来访问静态对象。




        Person ming = new Person("Xiao Ming", 12);
        Person hong = new Person("Xiao Hong", 15);
        ming.number = 88;
        System.out.println(hong.number);
        hong.number = 99;
        System.out.println(ming.number);
        System.out.println(Person.number);


        //静态方法
        //有静态字段，就有静态方法。用static修饰的方法称为静态方法。
    }

}

class Person{
    public String name;
    public int age;
    //定义静态字段
    public static int number;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void setNumber(int value) {
        number = value;
    }
}

interface Studnet {
    public static final int MALE = 1;
    public static final int FEMALE = 2;
    //实际上，因为interface的字段只能是public static final类型，所以我们可以把这些修饰符都去掉，上述代码可以简写为：
    //编译器会自动把该字段变为public static final类型。
}