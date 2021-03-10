package wz.life.base.day02.whileopertion;

/**
 * 循环语句就是让计算机根据条件做循环计算，
 * 在条件满足时继续循环，条件不满足时退出循环。
 *
 * @DESCRIPTION while
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/20 1:05 上午
 */
public class Main {

    public static void main(String[] args) {
        //总和
        int sum = 0;
        //次数100
        int n = 1;
        while(n <= 100){
            sum = sum + n;
            n++;
        }
        System.out.println(sum);



        //执行了101次
        int sum2 = 0;
        int n2 = 0;
        while (n2 <= 100) {
            n2 ++;
            sum2 = sum2 + n2;
        }
        System.out.println(sum2);


    }
}
