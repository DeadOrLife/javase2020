package wz.life.base.day05.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *BigDecimal用于表示精确的小数，常用于财务计算；
 *
 * 比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()。
 *
 * @DESCRIPTION BigDecimal
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/1 11:57 上午
 */
public class Main {
    public static void main(String[] args) {

        //和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数。
        BigDecimal bd = new BigDecimal("123.4567");
        //15241.55677489
        System.out.println(bd.multiply(bd));

        //判断有几位小数 使用scale() 表示小数位数
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0

        //通过BigDecimal的stripTrailingZeros()方法，
        // 可以将一个BigDecimal格式化为一个相等的，
        // 但去掉了末尾0的BigDecimal：

        BigDecimal d4 = new BigDecimal("123.4500");
        //去除末尾所有的0
        BigDecimal d5 = d4.stripTrailingZeros();
        //判断小数位数
        System.out.println(d4.scale());//4
        System.out.println(d5.scale());//2


        //如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。
        BigDecimal d6 = new BigDecimal("1234500");
        BigDecimal d7 = d6.stripTrailingZeros();
        System.out.println(d6.scale()); // 0
        System.out.println(d7.scale()); // -2

        //可以对一个BigDecimal设置它的scale，如果精度比原始值低，
        // 那么按照指定的方法进行四舍五入或者直接截断：

        BigDecimal d8 = new BigDecimal("123.456789");
        //四舍五入 123.4567
        BigDecimal d9 = d8.setScale(4, RoundingMode.HALF_UP);
        //直接截断
        BigDecimal d10 = d8.setScale(4,RoundingMode.DOWN);
        System.out.println(d9);//123.4568
        System.out.println(d10);//123.4567


        //对BigDecimal做加、减、乘时，精度不会丢失，
        // 但是做除法时，存在无法除尽的情况，
        // 这时，就必须指定精度以及如何进行截断：

        //BigDecimal的加减乘除
        BigDecimal d11 = new BigDecimal("12.345");
        BigDecimal d12 = new BigDecimal("23.456789");
        BigDecimal d13 = d11.divide(d12, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
//        BigDecimal d14 = d11.divide(d12); // 报错：ArithmeticException，因为除不尽


        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]);//102
        System.out.println(dr[1]);//0.105

        //调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，
        // 分别是商和余数，其中商总是整数，余数不会大于除数。
        // 我们可以利用这个方法判断两个BigDecimal是否是整数倍数：

        BigDecimal n1 = new BigDecimal("12.75");
        BigDecimal m1 = new BigDecimal("0.15");
        BigDecimal[] dr1 = n1.divideAndRemainder(m1);
        if (dr1[1].signum() == 0) {
            // n是m的整数倍
        }


        //在比较两个BigDecimal的值是否相等时，
        // 要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，
        // 还要求它们的scale()相等：


        BigDecimal d15 = new BigDecimal("123.456");
        BigDecimal d16 = new BigDecimal("123.45600");
        System.out.println(d15.equals(d16)); // false,因为scale不同
        System.out.println(d15.equals(d16.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
        System.out.println(d15.compareTo(d16)); // 0

        //必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
        // 总是使用compareTo()比较两个BigDecimal的值，不要使用equals()！

        //如果查看BigDecimal的源码，可以发现，实际上一个BigDecimal是通过一个BigInteger和一个scale来表示的，
        // 即BigInteger表示一个完整的整数，而scale表示小数位数：
        //BigDecimal也是从Number继承的，也是不可变对象。
    }
}
