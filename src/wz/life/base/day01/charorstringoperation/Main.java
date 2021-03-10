package wz.life.base.day01.charorstringoperation;

/**
 *
 * 小结
 * Java的字符类型char是基本类型，字符串类型String是引用类型；
 *
 * 基本类型的变量是“持有”某个数值，引用类型的变量是“指向”某个对象；
 *
 * 引用类型的变量可以是空值null；
 *
 * 要区分空值null和空字符串""。
 *
 * @DESCRIPTION 字符和字符串
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/10 12:27 上午
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 1.字符类型
         * 字符类型char是基本数据类型，
         * 它是character的缩写。一个char保存一个Unicode字符：
         */
        char c1 = 'A';
        char c2 = '中';

//        因为Java在内存中总是使用Unicode表示字符，
//        所以，一个英文字符和一个中文字符都用一个char类型表示，
//        它们都占用两个字节。要显示一个字符的Unicode编码，
//        只需将char类型直接赋值给int类型即可：
        int n1 = 'A';
        int n2 = '中';

        /*还可以直接用转义字符u+Unicode编码来表示一个字符：*/

        // 注意是十六进制:
        // 'A'，因为十六进制0041 = 十进制65
        // '中'，因为十六进制4e2d = 十进制20013
        char c3 = '\u0041';
        char c4 = '\u4e2d';


        /**
         * 2.字符串类型
         * 和char类型不同，字符串类型String是引用类型，
         * 我们用双引号"..."表示字符串。
         * 一个字符串可以存储0个到任意个字符：
         */

        // 包含7个字符: a, b, c, ", x, y, z
        String s = "abc\"xyz";
        // 包含7个字符: a, b, c, \, x, y, z
        String s2 = "abc\\xyz";


        /**
         * 常见的转义字符包括：
         *
         *         \" 表示字符"
         *         \' 表示字符'
         *         \\ 表示字符\
         *         \n 表示换行符
         *         \r 表示回车符
         *         \t 表示Tab
         *         u#### 表示一个Unicode编码的字符
         *
         */
        // 包含6个字符: A, B, C, 换行符, 中, 文
        String s3 = "ABC\n\u4e2d\u6587";


        /**
         * 3.字符串连接
         * Java的编译器对字符串做了特殊照顾，
         * 可以使用+连接任意字符串和其他数据类型，这样极大地方便了字符串的处理。例如：
         */
        String s4 = "Hello";
        String s5 = "world";
        String s6 = s4 + " " + s5 + "!";
        System.out.println(s6);

        //如果用+连接字符串和其他数据类型，
        // 会将其他数据类型先自动转型为字符串，再连接：
        int age = 25;
        String s9 = "age is " + age;
        System.out.println(s9);

        /**
         * 4.多行字符串
         * 如果我们要表示多行字符串，使用+号连接会非常不方便：
         *
         * 从Java 13开始，字符串可以用"""..."""表示多行字符串（Text Blocks）了。举个例子：
         */

//        String sql = """
//                   SELECT * FROM
//                     users
//                   WHERE id > 100
//                   ORDER BY name DESC
//                   """;
//        System.out.println(sql);


        /**
         * 5.不可变特性
         * 原来的字符串"hello"还在，只是我们无法通过变量s7访问它而已。
         * 因此，字符串的不可变是指字符串内容不可变。
         */
        String s7 = "hello";
        System.out.println(s7); // 显示 hello
        s7 = "world";
        System.out.println(s7); // 显示 world


        String s8 = "hello";
        String t = s8;
        s8 = "world";
        // t是"hello"还是"world"?
        //hello
        System.out.println(t);


        /**
         * 6.空值null
         * 引用类型的变量可以指向一个空值null，
         * 它表示不存在，即该变量不指向任何对象。例如：
         */
        String ss1 = null; // s1是null
        String ss2; // 没有赋初值值，s2也是null
        String ss3 = ss1; // s3也是null
        String ss4 = ""; // s4指向空字符串，不是null





    }
}
