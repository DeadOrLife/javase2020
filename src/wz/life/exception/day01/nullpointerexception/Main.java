package wz.life.exception.day01.nullpointerexception;

/**
 *
 * NullPointerException是Java代码常见的逻辑错误，应当早暴露，早修复；
 *
 * 可以启用Java 14的增强异常信息来查看NullPointerException的详细错误信息。
 *
 * java -XX:+ShowCodeDetailsInExceptionMessages Main.java
 *
 * @DESCRIPTION 空指针
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/2 11:03 上午
 */
public class Main {

    public static void main(String[] args) {
        //在所有的RuntimeException异常中，
        // Java程序员最熟悉的恐怕就是NullPointerException了。
        //
        //NullPointerException即空指针异常，俗称NPE。
        // 如果一个对象为null，调用其方法或访问其字段就会产生NullPointerException，
        // 这个异常通常是由JVM抛出的，例如：

        String s = null;
        System.out.println(s.toLowerCase());

        //处理NullPointerException
        //如果遇到NullPointerException，我们应该如何处理？
        // 首先，必须明确，NullPointerException是一种代码逻辑错误，
        // 遇到NullPointerException，
        // 遵循原则是早暴露，早修复，严禁使用catch来隐藏这种编码错误：


        //定位NullPointerException
//        如果产生了NullPointerException，例如，调用a.b.c.x()时产生了NullPointerException，原因可能是：
//
//        a是null；
//        a.b是null；
//        a.b.c是null；
//        确定到底是哪个对象是null以前只能打印这样的日志：

//        System.out.println(a);
//        System.out.println(a.b);
//        System.out.println(a.b.c);


//        从Java 14开始，如果产生了NullPointerException，
//        JVM可以给出详细的信息告诉我们null对象到底是谁。

        //这种增强的NullPointerException详细信息是Java 14新增的功能，
        // 但默认是关闭的，我们可以给JVM添加一个-XX:+ShowCodeDetailsInExceptionMessages参数启用它：







    }
}
