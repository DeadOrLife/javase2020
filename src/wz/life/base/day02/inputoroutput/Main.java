package wz.life.base.day02.inputoroutput;

import java.util.Scanner;

/**
 *
 * 小结
 * Java提供的输出包括：System.out.println() / print() / printf()，其中printf()可以格式化输出；
 *
 * Java提供Scanner对象来方便输入，读取对应的类型可以使用：scanner.nextLine() / nextInt() / nextDouble() / ...
 *
 * println是print line的缩写，表示输出并换行。
 * 因此，如果输出后不想换行，可以用print()：
 *
 * @DESCRIPTION 输入输出
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/16 12:49 上午
 */
public class Main {

    public static void main(String[] args) {
        /**
         * 1.输出
         */
        System.out.print("A，");
        System.out.print("B，");
        System.out.print("C，");
        System.out.println();
        System.out.println("END");


        /**
         * 2.格式化输出
         * Java还提供了格式化输出的功能。
         * 为什么要格式化输出？
         * 因为计算机表示的数据不一定适合人来阅读：
         *
         * 如果要把数据显示成我们期望的格式，
         * 就需要使用格式化输出的功能。
         * 格式化输出使用System.out.printf()，
         * 通过使用占位符%?，printf()可以把后面的参数格式化成指定格式：
         *
         * Java的格式化功能提供了多种占位符，
         * 可以把各种数据类型“格式化”成指定的字符串：
         *
         * %d 格式化输出整数
         * %x 格式化输出十六进制整数
         * %f 格式化输出浮点数
         * %e 格式化输出科学计数法表示的浮点数
         * %s 格式化字符串
         *
         */
        double d = 12900000;
        //1.29E7
        System.out.println(d);

        double c = 3.1415926;
        //显示两位小数 \n :表示换行
        System.out.printf("%.2f\n",c);

        //显示4位小数
        System.out.printf("%.4f\n",c);

        int e = 101;
        //格式化整数
        System.out.printf("%d\n",e);
        System.out.printf("%x\n",e);
        System.out.printf("%e\n",d);
        System.out.printf("%s\n",e);

        /**
         * 3.输入
         */
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your name:");
        //读取一行输入并获取字符串
        String name = scanner.nextLine();
        System.out.println("Input your age:");
        //读取一行输入并获取整数
        int age = scanner.nextInt();
        //格式化输出
        System.out.printf("Hi ,%s,your are %d\n",name,age);

    }

}
