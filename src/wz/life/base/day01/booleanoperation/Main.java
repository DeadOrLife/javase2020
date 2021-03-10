package wz.life.base.day01.booleanoperation;

/**
 * 小结
 *
 * 与运算和或运算是短路运算；
 *
 * 三元运算b ? x : y后面的类型必须相同，三元运算也是“短路运算”，只计算x或y。
 *
 * @DESCRIPTION 布尔运算
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/10 12:14 上午
 */
public class Main {

    public static void main(String[] args) {


        /**
         * 1.布尔运算
         *
         * 对于布尔类型boolean 永远只有true与false
         *
         * 是一种关系运算
         *
         * 比较运算符：> >= < <= == !=
         * 与：& &&
         * 或：| ||
         * 非：!
         *
         * 关系运算符的优先级从高到低依次是：
         * !
         * > >= < <=
         * == !=
         * &&
         * ||
         *
         */

        //true
        boolean isGreater = 5 > 3;

        int age = 12;
        //false
        boolean isZero = age ==0;
        //false
        boolean isAdult = age > 18;
        //true
        boolean isTeenager = age > 6 && age < 18;


        /**
         * 2.短路运算
         * 布尔运算的一个重要特点是短路运算。
         * 如果一个布尔运算的表达式能提前确定结果，
         * 则后续的计算不再执行，直接返回结果。
         */

        boolean b = 5 < 3;
        boolean result = b && (5 / 0 > 0);
        //false
        System.out.println(result);

        //true
        boolean result2 = true || (5 / 0 > 0);
        System.out.println(result2);


        /**
         * 3.三元运算符
         * Java还提供一个三元运算符b ? x : y，
         * 它根据第一个布尔表达式的结果，
         * 分别返回后续两个表达式之一的计算结果。示例：
         */
        int n = -100;
        int x = n >=0 ? n : -n;
        //100
        System.out.println(x);

    }


}
