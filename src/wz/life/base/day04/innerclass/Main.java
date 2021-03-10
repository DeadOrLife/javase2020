package wz.life.base.day04.innerclass;

import java.util.HashMap;

/**
 *
 * 观察上述代码，要实例化一个Inner，我们必须首先创建一个Outer的实例，然后，调用Outer实例的new来创建Inner实例：
 *
 * Outer.Inner inner = outer.new Inner();
 * 这是因为Inner Class除了有一个this指向它自己，还隐含地持有一个Outer Class实例，可以用Outer.this访问这个实例。所以，实例化一个Inner Class不能脱离Outer实例。
 *
 * Inner Class和普通Class相比，除了能引用Outer实例外，还有一个额外的“特权”，就是可以修改Outer Class的private字段，因为Inner Class的作用域在Outer Class内部，所以能访问Outer Class的private字段和方法。
 *
 * 观察Java编译器编译后的.class文件可以发现，Outer类被编译为Outer.class，而Inner类被编译为Outer$Inner.class。
 *
 * 如果一个类定义在另一个类的内部，这个类就是Inner Class：
 *
 *
 * ava的内部类可分为Inner Class、Anonymous Class和Static Nested Class三种：
 *
 * Inner Class和Anonymous Class本质上是相同的，都必须依附于Outer Class的实例，即隐含地持有Outer.this实例，并拥有Outer Class的private访问权限；
 *
 * Static Nested Class是独立类，但拥有Outer Class的private访问权限。
 * @DESCRIPTION 内部类
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/8 11:58 下午
 */
public class Main{

    public static void main(String[] args) {
        Outer outer = new Outer("Nested"); // 实例化一个Outer
        Outer.Inner inner = outer.new Inner(); // 实例化一个Inner
        inner.hello();
        //内部类可以访问外部类的 prvate 字段与方法

        //匿名类

        HashMap<String,String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<String, String>() {}; // 匿名类!

        HashMap<String,String> map3 = new HashMap<String, String>(){
            {
                put("a","1");
                put("b","2");
            }
        };
        System.out.println(map3.get("a"));




    }
}
class Outer {
    private String name;
    private static String name2;

    Outer(String name){
        this.name = name;
    }

    class Inner{
        //定义了一个内部类
        void hello(){
            System.out.println("hello"+Outer.this.name);
        }
    }

    void asyncHello(){
        Runnable r = new Runnable(){

            @Override
            public void run() {
                System.out.println("hello" + Outer.this.name);
            }
        };
        new Thread(r).start();

    }


//    用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，
//    而是一个完全独立的类，因此无法引用Outer.this，但它可以访问Outer的private静态字段和静态方法。
//    如果把StaticNested移到Outer之外，就失去了访问private的权限。
    //静态内部类
    static class Staticnested{
        void hello(){
            System.out.println("hello"+Outer.name2);
        }
    }







}
