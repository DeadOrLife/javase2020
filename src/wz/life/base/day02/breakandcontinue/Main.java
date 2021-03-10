package wz.life.base.day02.breakandcontinue;

/**
 *
 * break语句可以跳出当前循环；
 *
 * break语句通常配合if，在满足条件时提前结束整个循环；
 *
 * break语句总是跳出最近的一层循环；
 *
 * continue语句可以提前结束本次循环；
 *
 * continue语句通常配合if，在满足条件时提前结束本次循环。
 *
 * 无论是while循环还是for循环，
 * 有两个特别的语句可以使用，就是break语句和continue语句。
 * @DESCRIPTION break continue
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/22 11:34 下午
 */
public class Main {
    public static void main(String[] args) {

        /**
         * break
         * 因此，break语句通常都是配合if语句使用。
         * 要特别注意，break语句总是跳出自己所在的那一层循环。例如：
         */
        int sum = 0;
        for (int i = 0; ; i++) {
            sum += i;
            if (i==100){
                break;
            }
        }
        System.out.println(sum);


        for (int i = 0; i <=10; i++) {
            System.out.println("i= " + i);
            for (int j = 0; j <=10; j++) {
                System.out.println("j= "+j);
                if (j>=i){
                    break;
                }
            }
            System.out.println("breaked");
        }

        /**
         * continue
         * break会跳出当前循环，也就是整个循环都不会执行了。
         * 而continue则是提前结束本次循环，直接继续执行下次循环。我们看一个例子：
         */
        int num = 0;
        for (int i = 1;i<=10;i++){
            System.out.println("begin i = " + i);
            if (i % 2 == 0){
                continue;
            }
            num = num + i;
            System.out.println("end i = " + i);
        }
        System.out.println(num);




    }
}
