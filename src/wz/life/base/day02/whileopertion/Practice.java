package wz.life.base.day02.whileopertion;

/**
 * 小结
 * while循环先判断循环条件是否满足，再执行循环语句；
 *
 * while循环可能一次都不执行；
 *
 * 编写循环时要注意循环条件，并避免死循环。
 * @DESCRIPTION 计算m到n的和
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/20 1:17 上午
 */
public class Practice {
    public static void main(String[] args) {
        int sum = 0;
        int m = 20;
        int n = 100;
        int num = n - m;
        int i = 0;
        while (i <= num){
            sum = sum + m + i;
            i++;
        }
        System.out.println(sum);
    }
}
