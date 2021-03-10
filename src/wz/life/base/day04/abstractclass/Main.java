package wz.life.base.day04.abstractclass;

/**
 *
 * 通过abstract定义的方法是抽象方法，它只有定义，没有实现。抽象方法定义了子类必须实现的接口规范；
 *
 * 定义了抽象方法的class必须被定义为抽象类，从抽象类继承的子类必须实现抽象方法；
 *
 * 如果不实现抽象方法，则该子类仍是一个抽象类；
 *
 * 面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现。
 *
 *
 * 把一个方法声明为abstract，
 * 表示它是一个抽象方法，本身没有实现任何方法语句
 * 因为这个抽象方法本身是无法执行的，
 * 所以，Person类也无法被实例化。
 * 编译器会告诉我们，无法编译Person类，因为它包含抽象方法。
 *
 * 抽象方法：
 * 如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
 *
 * @DESCRIPTION 抽象类
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/26 10:33 下午
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        p.run();
    }
}

abstract class Person{
    public abstract void run();
}

class Student extends Person{

    @Override
    public void run(){
        System.out.println("Student.run");
    }
}

class Teacher extends Person{
    @Override
    public void run() {

    }
}

