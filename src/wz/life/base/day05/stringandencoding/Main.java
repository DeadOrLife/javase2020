package wz.life.base.day05.stringandencoding;

import javax.xml.soap.SOAPMessage;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * Java字符串String是不可变对象；
 *
 * 字符串操作不改变原字符串内容，而是返回新字符串；
 *
 * 常用的字符串操作：提取子串、查找、替换、大小写转换等；
 *
 * Java使用Unicode编码表示String和char；
 *
 * 转换编码就是将String和byte[]转换，需要指定编码；
 *
 * 转换为byte[]时，始终优先考虑UTF-8编码。
 *
 *
 *在Java中，String是一个引用类型，它本身也是一个class。
 * 但是，Java编译器对String有特殊处理，即可以直接用"..."来表示一个字符串：
 *
 * Java字符串的一个重要特点就是字符串不可变。
 * 这种不可变性是通过内部的private final char[]字段，
 * 以及没有任何修改char[]的方法实现的。
 *
 * @DESCRIPTION 字符串与编码
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/24 11:13 下午
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "Hello";
        System.out.println(s);
        //转大写
        s = s.toUpperCase();
        System.out.println(s);

        //字符串的比较
        //当我们想要比较两个字符串是否相同时，
        // 要特别注意，我们实际上是想比较字符串的内容是否相同。
        // 必须使用equals()方法而不能用==。

        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1==s2);//true
        System.out.println(s1.equals(s2));//true

        String s3 = "hello";
        String s4 = "HELLO".toLowerCase();
        System.out.println(s3 == s4);//false
        System.out.println(s3.equals(s4));//true

        //要忽略大小写比较，使用equalsIgnoreCase()方法。
        String s5 = "hELLo";
        System.out.println(s3.equalsIgnoreCase(s5));//true

        // 是否包含子串:
        //注意到contains()方法的参数是CharSequence而不是String，
        // 因为CharSequence是String的父类。
        System.out.println("Hello".contains("ll"));//true

        //搜索子串的更多的例子：
        System.out.println("Hello".indexOf("l"));//2
        System.out.println("Hello".lastIndexOf("l"));//3
        System.out.println("Hello".startsWith("He"));//true
        System.out.println("Hello".endsWith("lo"));//true

        //提取子串的例子：注意索引号是从0开始的。
        System.out.println("Hello".substring(2));//llo
        System.out.println("Hello".substring(2, 4));//ll

        //去除首尾空白字符 使用trim()方法可以移除字符串首尾空白字符。
        //空白字符包括空格，\t，\r，\n：
        //注意：trim()并没有改变字符串的内容，而是返回了一个新字符串。
        System.out.println("  \tHello\r\n ".trim());//Hello


        //另一个strip()方法也可以移除字符串首尾空白字符。
        // 它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
        //JDK11中引入String.strip()
//        System.out.println("\u3000Hello\u3000".strip());//Hello
//        System.out.println(" Hello ".stripLeading());//"Hello "
//        System.out.println(" Hello ".stripTrailing());//" Hello"


        //String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
        //JDK11中引入String.isBlank()
        System.out.println("".isEmpty());
        System.out.println("  ".isEmpty());
//        System.out.println(" \n".isBlank());
//        System.out.println(" Hello".isBlank());

        System.out.println("".isEmpty()); // Prints - True
        System.out.println(" ".isEmpty()); //Prints - False

//        Java 11之前

        boolean blank = "ASD ".trim().isEmpty();
//        Java 11之后

//        boolean blank2=" XAS ".isblank();


        //替换子串
        String s6 = "hello";
        // "hewwo"，所有字符'l'被替换为'w'
        System.out.println(s6.replace('l', 'w'));
        // "he~~o"，所有子串"ll"被替换为"~~"
        System.out.println( s6.replace("ll", "~~"));

        //另一种是通过正则表达式替换：
        String s7 = "A,,B;C ,D";
        System.out.println(s7.replaceAll("[\\,\\;\\s]+", ","));// "A,B,C,D"

        //分割字符串
        String s8 = "A,B,C,D";
        String[] ss = s8.split("\\,"); // {"A", "B", "C", "D"}

        //拼接字符串
        String[] arr = {"A", "B", "C"};
        String s9 = String.join("***", arr); // "A***B***C"

        //格式化字符串
        //字符串提供了formatted()方法和format()静态方法，
        // 可以传入其他参数，替换占位符，然后生成新的字符串：
        String s10 = "Hi %s, your score is %d!";
//        System.out.println(s10.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));


        //有几个占位符，后面就传入几个参数。参数类型要和占位符一致。我们经常用这个方法来格式化信息。常用的占位符有：
        //%s：显示字符串；
        //%d：显示整数；
        //%x：显示十六进制整数；
        //%f：显示浮点数。


        //类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255


        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false

        //要特别注意，Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        Integer.getInteger("java.version"); // 版本号，11


        //String和char[]类型可以互相转换，方法是：
//        char[] cs = "Hello".toCharArray(); // String -> char[]
//        String s11 = new String(cs); // char[] -> String

        //这是因为通过new String(char[])创建新的String实例时，
        // 它并不会直接引用传入的char[]数组，
        // 而是会复制一份，所以，修改外部的char[]数组不会影响String实例内部的char[]数组，
        // 因为这是两个不同的数组。
        char[] cs = "Hello".toCharArray();
        String s12 = new String(cs);
        System.out.println(s12);
        cs[0] = 'X';
        System.out.println(s12);


        //观察两次输出，由于Score内部直接引用了外部传入的int[]数组，
        // 这会造成外部代码对int[]数组的修改，
        // 影响到Score类的字段。如果外部代码不可信，
        // 这就会造成安全隐患。
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s13 = new Score(scores);
        s13.printScores();
        scores[2] = 99;
        s13.printScores();



        //字符编码
        byte[] b4 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b5 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b6 = "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] b7 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        System.out.println(b4);

        //始终牢记：Java的String和char在内存中总是以Unicode编码表示。
    }
}


class Score {
    private int[] scores;
    public Score(int[] scores) {
        //请修复Score的构造方法，使得外部代码对数组的修改不影响Score实例的int[]字段。
        this.scores=scores.clone();

//        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}

