package wz.life.base.day03.ergodicarray;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * 遍历数组可以使用for循环，for循环可以访问数组索引，for each循环直接迭代每个数组元素，但无法获取索引；
 *
 * 使用Arrays.toString()可以快速获取数组内容。
 * @DESCRIPTION 遍历数组
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/22 11:46 下午
 */
public class Main {
    public static void main(String[] args) {
        int[] ns = {1,3,9,16,25};
        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }

        for(int n: ns){
            System.out.println(n);
        }

        System.out.println(Arrays.toString(ns));


        for(int i = ns.length-1 ; i>=0;i--){
            System.out.println(ns[i]);
        }

        //Arrays.stream(ns).forEach(System.out::println);
//        Stream.of(ns).forEach(System.out::print);
    }
}
