package wz.life.base.day02.foroperation;

/**
 * for循环通过计数器可以实现复杂循环；
 * <p>
 * for each循环可以直接遍历数组的每个元素；
 * <p>
 * 最佳实践：计数器变量定义在for循环内部，循环体内部不修改计数
 *
 * @DESCRIPTION for 循环
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/20 11:41 下午
 */
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println(sum);

        int[] ns = {1, 4, 9, 16, 25};
        int su = 0;
        for (int i = 0; i < ns.length; i++) {
            System.out.println("i=" + i + ",ns[i]=" + ns[i]);
            su = su + ns[i];
        }
        System.out.println("su = " + su);


        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i]);
            i = i + 1;
        }


        /**
         * 灵活使用for循环
         * for循环还可以缺少初始化语句、循环条件和每次循环更新语句，例如：
         */

        //for(int i=0; ; i++){}
        //for(;;){}

        /**
         * for each循环
         * 和for循环相比，for each循环的变量n不再是计数器，
         * 而是直接对应到数组的每个元素。
         * for each循环的写法也更简洁。
         * 但是，for each循环无法指定遍历顺序，
         * 也无法获取数组的索引。
         */
        for (int n : ns) {
            System.out.println(n);
        }


    }
}
