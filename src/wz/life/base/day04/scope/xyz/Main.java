package wz.life.base.day04.scope.xyz;

import wz.life.base.day04.scope.abc.Hello;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/7 11:44 下午
 */
public class Main extends Hello{
    void foo(){
        //Main 可以访问Hello
        Hello h = new Hello();
        //上面的hi()方法是public，可以被其他类调用，前提是首先要能访问Hello类：
//        h.hi();

        //上面的protected方法可以被继承的类访问：
        hi();
    }

    public static void main(String[] args) {
        Inner i = new Inner();
        i.hi();
    }

    private static void hello(){
        System.out.println("private hello");
    }

    //由于Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限：
    static class Inner{
        public void hi(){
            Main.hello();
        }
    }
}
