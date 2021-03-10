package wz.life.base.day02.foroperation;

/**
 * @DESCRIPTION for循环 练习
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/22 11:22 下午
 */
public class Practice {

    public static void main(String[] args) {
        /**
         * 给定一个数组，请用for循环倒序输出每一个元素：
         */
        int[] ns = {1,2,9,16,25};
        for (int i=0;i<ns.length;i++){
            System.out.println(ns[i]);
        }

        /**
         * 利用for each循环对数组每个元素求和：
         */
        int sum = 0;
        for(int n : ns){
            sum = sum + n;
        }
        System.out.println("sum=" + sum);

        /**
         * 圆周率π可以使用公式计算：
         * 请利用for循环计算π：
         */
    }
}
