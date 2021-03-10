package wz.life.base.day04.polymorphic;

/**
 * 在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）。
 *
 * Override和Overload不同的是，如果方法签名如果不同，就是Overload，
 * Overload方法是一个新方法；如果方法签名相同，并且返回值也相同，就是Override。
 *
 * 子类可以覆写父类的方法（Override），覆写在子类中改变了父类方法的行为；
 *
 * Java的方法调用总是作用于运行期对象的实际类型，这种行为称为多态；
 *
 * final修饰符有多种作用：
 *
 * final修饰的方法可以阻止被覆写；
 *
 * final修饰的class可以阻止被继承；
 *
 * final修饰的field必须在创建对象时初始化，随后不可修改。
 * @DESCRIPTION 多态
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/25 11:47 下午
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        p.run(); // 应该打印Person.run还是Student.run?
//        Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。


    }
}
class Person {
    public void run() {
        System.out.println("Person.run");
    }
}
class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}