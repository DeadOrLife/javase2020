package wz.life.base.day03.multidimensionalarray;

/**
 * @DESCRIPTION 多维数组
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/30 12:03 上午
 */
public class Main {

    public static void main(String[] args) {

        int[][] ns = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(ns.length);

        int[] arr0 = ns[0];
        System.out.println(arr0.length);

        for (int[] arr: ns
             ) {
            for (int n:arr
                 ) {
                System.out.println(n);
            }
        }
    }
}
