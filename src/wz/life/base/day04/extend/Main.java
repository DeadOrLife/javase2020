package wz.life.base.day04.extend;

/**
 *
 * 在OOP的术语中，我们把Person称为超类（super class），父类（parent class），基类（base class），
 * 把Student称为子类（subclass），扩展类（extended class）。
 *
 * Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。
 *
 * 继承有个特点，就是子类无法访问父类的private字段或者private方法。例如，Student类就无法访问Person类的name和age字段：
 *
 *
 * 继承是面向对象编程的一种强大的代码复用方式；
 *
 * Java只允许单继承，所有类最终的根类是Object；
 *
 * protected允许子类访问父类的字段和方法；
 *
 * 子类的构造方法可以通过super()调用父类的构造方法；
 *
 * 可以安全地向上转型为更抽象的类型；
 *
 * 可以强制向下转型，最好借助instanceof判断；
 *
 * 子类和父类的关系是is，has关系不能用继承
 *
 * @DESCRIPTION 继承
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/25 11:29 下午
 */
public class Main {
    public static void main(String[] args) {
        //向上转型
        Student s = new Student();
        Person p = s; // upcasting, ok
        Object o1 = p; // upcasting, ok
        Object o2 = s; // upcasting, ok


        //向下转型
        Person p1 = new Student(); // upcasting, ok
        Person p2 = new Person();
        Student s1 = (Student) p1; // ok
        Student s2 = (Student) p2; // runtime error! ClassCastException!
//        Person类型p1实际指向Student实例，Person类型变量p2实际指向Person实例。在向下转型的时候，把p1转型为Student会成功，因为p1确实指向Student实例，把p2转型为Student会失败，因为p2的实际类型是Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。
//        因此，向下转型很可能会失败。失败的时候，Java虚拟机会报ClassCastException。

//        为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型：
        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Student); // false

        System.out.println(s instanceof Person); // true
        System.out.println(s instanceof Student); // true

        Student n = null;
        System.out.println(n instanceof Student); // false


        if (p instanceof Student) {
            // 只有判断成功才会向下转型:
            Student s3 = (Student) p; // 一定会成功
        }
    }
}
class Person {
    protected String name;
    protected int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    private String name;
//    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String hello() {
        return "Hello, " + super.name;
    }

    public Student() {
        super();
    }

    public Student(String name, int age, int score) {
        super(name, age); // 调用父类的构造方法Person(String, int)
        this.score = score;
    }

    //因此，继承是is关系，组合是has关系。
    protected Book book;
}

class Book {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}