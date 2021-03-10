package wz.life.base.day04.method;

import java.util.Arrays;

/**
 *
 * 在OOP中，class和instance是“模版”和“实例”的关系；
 *
 * 定义class就是定义了一种数据类型，对应的instance是这种数据类型的实例；
 *
 * class定义的field，在每个instance都会拥有各自的field，且互不干扰；
 *
 * 通过new操作符创建新的instance，然后用变量指向它，即可通过变量来引用这个instance；
 *
 * 访问实例字段的方法是变量名.字段名；
 *
 * 指向instance的变量都是引用变量。
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/11/10 10:14 下午
 */
public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.name2 = "XIAO MING";
        ming.age2 = 2;
        ming.setNameAndAge("jia jia",2);
        ming.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
        ming.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
        ming.setNames("Xiao Ming"); // 传入1个String
        ming.setNames(); // 传入0个String
        ming.setNames(new String[] {"Xiao Ming", "Xiao Hong", "Xiao Jun"}); // 传入1个String[]
        ming.setNamesArr(new String[] {"Xiao Ming", "Xiao Hong", "Xiao Jun"}); // 传入1个String[]

        //而可变参数可以保证无法传入null，
        // 因为传入0个参数时，接收到的实际值是一个空数组而不是null。


        ming.setNamesArr(null);
        ming.setNames(null);


        /**
         * 结论：基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
         */
        Person p0 = new Person();
        int n = 15; // n的值为15
        p0.setAge(n); // 传入n的值
        System.out.println(p0.getAge()); // 15
        n = 20; // n的值改为20
        System.out.println(p0.getAge()); // 15还是20?

        /**
         * 结论：引用类型参数的传递，调用方的变量，和接收方的参数变量，
         * 指向的是同一个对象。双方任意一方对这个对象的修改，
         * 都会影响对方（因为指向同一个对象嘛）。
         */

        Person p = new Person();
        String[] fullname = new String[] { "Homer", "Simpson" };
        p.setName3(fullname); // 传入fullname数组
        System.out.println(p.getName3()); // "Homer Simpson"
        fullname[0] = "Bart"; // fullname数组的第一个元素修改为"Bart"
        System.out.println(p.getName3()); // "Homer Simpson"还是"Bart Simpson"?


        /**
         * 结论：String的值是不可变的 ，对String 重新赋值的时候，会重新创建一个bob的引用；
         */
        Person p2 = new Person();
        String bob = "Bob";
        p2.setName(bob); // 传入bob变量
        System.out.println(p2.getName()); // "Bob"
        bob = "Alice"; // bob改名为Alice
        System.out.println(p2.getName()); // "Bob"还是"Alice"?
    }
}

class Person{
    /**
     * private 修饰的field 拒绝外部访问
     */
    private String name;
    private int age;
    private int brith;

    //所以，一个类通过定义方法，
    // 就可以给外部代码暴露一些操作的接口，
    // 同时，内部自己保证逻辑一致性。
    public String getName() {
        //等同与 this.name
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("invalid name");
        }
        //如果有局部变量和字段重名，那么局部变量优先级更高，就必须加上this
        this.name = name;
    }

    public int getAge() {
        //定义private方法的理由是内部方法是可以调用private方法的

        calcAge(2019);
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 100){
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public String name2;
    public int age2;

    private int calcAge(int currentYear){
        return currentYear - this.brith;

    }

    /**
     * this 变量
     * 在方法内部，可以使用一个隐含的变量this，
     * 它始终指向当前实例。因此，通过this.field就可以访问当前实例的字段。
     */

    /**
     * 方法可以包含0个或任意个参数。
     * 方法参数用于接收传递给方法的变量值。
     * 调用方法时，必须严格按照参数的定义一一传递。例如：
     * 调用这个setNameAndAge()方法时，
     * 必须有两个参数，
     * 且第一个参数必须为String，
     * 第二个参数必须为int：
     * @param name
     * @param age
     */
    public void setNameAndAge(String name, int age) {

    }

    /**
     * 可变参数
     * 变参数相当于数组类型：
     * ...
     */
    public void setNames(String... names) {
        System.out.println(Arrays.toString(names));
    }
    public void setNamesArr(String[] names) {

    }


    private String[] name3;

    public String getName3() {
        return this.name3[0] + " " + this.name3[1];
    }

    public void setName3(String[] name3) {
        this.name3 = name3;
    }

}
