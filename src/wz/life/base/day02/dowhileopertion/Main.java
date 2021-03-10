package wz.life.base.day02.dowhileopertion;

/**
 *
 * do while循环先执行循环，再判断条件；
 *
 * do while循环会至少执行一次。
 *
 * 在Java中，while循环是先判断循环条件，
 * 再执行循环。而另一种do while循环则是先执行循环，
 * 再判断条件，条件满足时继续循环，条件不满足时退出。
 *
 * @DESCRIPTION do...while
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/20 1:23 上午
 */
public class Main {

    public static void main(String[] args) {
        int sum = 0;
        int n = 1;
        do {
            sum = sum + n;
            n++;
        }while (n <= 100);
        System.out.println(sum);


        int sum2 = 0;
        int m2 = 20;
        int n2 = 100;
        int num2 = n2- m2;
        int i2 = 0;
        // 使用do while计算M+...+N:
        do {
            sum2 = sum2 + m2 + i2;
            i2++;
        } while (i2 <= num2);
        System.out.println(sum2);
    }

}
