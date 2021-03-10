package wz.life.base.day03.sortarray;

import java.util.Arrays;

/**
 * @DESCRIPTION 数组排序
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/22 11:58 下午
 */
public class Main {
    public static void main(String[] args) {
        int[] ns = {28,12,89,73,65,18,96,50,8,36};
        System.out.println("冒泡排序:");
        System.out.println("排序前:");
        System.out.println(Arrays.toString(ns));
        for (int i = 0;i<ns.length;i++){
            for (int j = 0; j < ns.length - i -1; j++) {
                if (ns[j] > ns[j+1]){
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        System.out.println("排序后:");
        System.out.println(Arrays.toString(ns));

        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));

    }
}
