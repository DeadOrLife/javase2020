package wz.life.base.day02.ifoperation;

/**
 * @DESCRIPTION if判断 的用法
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/18 11:02 下午
 */
public class Main {
    public static void main(String[] args) {

        /**
         * 1.if判断
         * 根据条件来决定是否执行某一段代码
         */
        int n = 70;
        if(n >= 60){
            System.out.println("及格了");
            System.out.println("恭喜你");
        }
        System.out.println("END");

        /**
         * 2.else
         * if语句还可以编写一个else { ... }，
         * 当条件判断为false时，将执行else的语句块：
         */
        if (n >=60){
            System.out.println("及格了");
        }else{
            System.out.println("挂科了");
        }
        System.out.println("及格了");

        if (n >= 90) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");


        double x = 1 - 9.0 / 10;
        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        /**
         * 3.判断引用类型相等
         * 在Java中，判断值类型的变量是否相等，
         * 可以使用==运算符。但是，判断引用类型的变量是否相等，
         * ==表示“引用是否相等”，
         * 或者说，是否指向同一个对象。
         * 例如，下面的两个String类型，它们的内容是相同的，
         * 但是，分别指向不同的对象，用==判断，结果为false：
         */

        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if( s1 == s2){
            System.out.println("s1 == s2");
        }else{
            System.out.println("s1 != s2");
        }

        //要判断引用类型的变量内容是否相等，必须使用equals()方法：

        if(s1.equals(s2)){
            System.out.println("s1 equals s2");
        }else {
            System.out.println("s1 not equals s2");
        }


        String s3 = null;
        if (s3.equals("hello")) {
            System.out.println("hello");
        }

        //要避免NullPointerException错误，可以利用短路运算符&&：
        if (s3 != null && s3.equals("hello")) {
            System.out.println("hello");
        }
    }
}
