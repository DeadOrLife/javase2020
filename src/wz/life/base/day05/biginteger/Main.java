package wz.life.base.day05.biginteger;

import java.math.BigInteger;

/**
 *
 * 在Java中，由CPU原生提供的整型最大范围是64位long型整数。
 * 使用long型整数可以直接通过CPU指令进行计算，速度非常快。
 *
 * 如果我们使用的整数范围超过了long型怎么办？这个时候，
 * 就只能用软件来模拟一个大整数。
 * java.math.BigInteger就是用来表示任意大小的整数。
 * BigInteger内部用一个int[]数组来模拟一个非常大的整数：
 *
 * BigInteger用于表示任意大小的整数；
 *
 * BigInteger是不变类，并且继承自Number；
 *
 * 将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确。
 *
 * @DESCRIPTION BigInteger
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/1 10:47 上午
 */
public class Main {

    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1234567890");
        //bi的5次方
        //2867971860299718107233761438093672048294900000
        System.out.println(bi.pow(5));

        //对BigInteger做运算的时候，只能使用实例方法，例如，加法运算：
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        //加法
        BigInteger sum = i1.add(i2);
        //234567891358024680
        System.out.println(sum);
        //和long型整数运算比，BigInteger不会有范围限制，但缺点是速度比较慢。
        //也可以把BigInteger转换成long型：

        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue());
        //乘法 转long类型 但是
        //使用longValueExact()方法时，如果超出了long型的范围，会抛出ArithmeticException。
        //java.lang.ArithmeticException: BigInteger out of long range
        //System.out.println(i.multiply(i).longValueExact());


//        BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。因为Number定义了转换为基本类型的几个方法：
//
//        转换为byte：byteValue()
//        转换为short：shortValue()
//        转换为int：intValue()
//        转换为long：longValue()
//        转换为float：floatValue()
//        转换为double：doubleValue()
//        因此，通过上述方法，可以把BigInteger转换成基本类型。如果BigInteger表示的范围超过了基本类型的范围，转换时将丢失高位信息，即结果不一定是准确的。如果需要准确地转换成基本类型，可以使用intValueExact()、longValueExact()等方法，在转换时如果超出范围，将直接抛出ArithmeticException异常。


        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        //Infinity
        System.out.println(f);










    }
}
