package wz.life.base.day04.constructionmethod;

/**
 * 由于构造方法是如此特殊，所以构造方法的名称就是类名。
 * 构造方法的参数没有限制，在方法内部，也可以编写任意语句。
 * 但是，和普通方法相比，构造方法没有返回值（也没有void），
 * 调用构造方法，必须用new操作符。
 * 没有在构造方法中初始化字段时，
 *
 * 引用类型的字段默认是null，
 * 数值类型的字段用默认值，int类型默认值是0，
 * 布尔类型默认值是false
 *
 * 在Java中，创建对象实例的时候，按照如下顺序进行初始化：
 * 1.先初始化字段，例如，int age = 10;表示字段初始化为10，double salary;表示字段默认初始化为0，String name;表示引用类型字段默认初始化为null；
 *
 * 2.执行构造方法的代码进行初始化。
 *
 *
 * 实例在创建时通过new操作符会调用其对应的构造方法，构造方法用于初始化实例；
 *
 * 没有定义构造方法时，编译器会自动创建一个默认的无参数构造方法；
 *
 * 可以定义多个构造方法，编译器根据参数自动判断；
 *
 * 可以在一个构造方法内部调用另一个构造方法，便于代码复用。
 *
 * @DESCRIPTION 构造方法
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/25 11:18 下午
 */
public class Main {
    public static void main(String[] args) {
        //创建对象的时候 对对象的属性进行初始化
        Person p = new Person("Xiao Ming", 15);
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }

}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    //要特别注意的是，如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法：
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
