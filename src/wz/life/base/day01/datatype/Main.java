package wz.life.base.day01.datatype;

/**
 * @DESCRIPTION java的数据类型
 *
 * 注意到第一次定义变量x的时候，
 * 需要指定变量类型int，因此使用语句int x = 100;。
 * 而第二次重新赋值的时候，变量x已经存在了，不能再重复定义，
 * 因此不能指定变量类型int，必须使用语句x = 200;。
 *
 * java定义了8种基本类型
 * 整数类型 btye short int long
 * 浮点类型 float double
 * 字符类型 char
 * 布尔类型 boolean
 *
 *
 * 1个字节=8bit(位)=一个8位二进制数
 *
 * 1byte
 * 1024byte = 1k
 * 1024k = 1M
 * 1024M = 1G
 * 1024G = 1T
 *
 * 特别注意：同一个数的不同进制的表示是完全相同的，例如15=0xf＝0b1111。
 *
 * 对于float类型，需要加上f后缀。
 *
 * Java语言对布尔类型的存储并没有做规定，
 * 因为理论上存储布尔类型只需要1 bit，
 * 但是通常JVM内部会把boolean表示为4字节整数。
 *
 * 注意char类型使用单引号'，且仅有一个字符，
 * 要和双引号"的字符串类型区分开。
 *
 * @AUTHOR: jamesbean
 * @DATE: 2020/9/19 12:15 上午
 */
public class Main {

    public static void main(String[] args) {
        //上述语句定义了一个整型int类型的变量，名称为x，初始值为1。
        int x = 1;
        // 打印该变量的值
        System.out.println(x);
        //重新赋值为200
        x = 200;
        //打印该变量的值，观察是否为200
        System.out.println(x);

        //变量之间的赋值
        //定义变量n，同时赋值为100
        int n = 100;
        //打印n的值 为100
        System.out.println("n = " + n);

        //变量n赋值为200
        n = 200;
        //打印n的值 为200
        System.out.println("n = " + n);

        //变量x赋值为x+100
        x = x + 100;
        //打印x的值 为300
        System.out.println("x = " + x);


        //定义整型
        int i = 2147483647;
        int i2 = -2147483648;
        //加下划线更容易识别
        int i3 = 2_000_000_000;
        //十六进制表示的
        int i4 = 0xff0000;
        //二进制表示的
        int i5 = 0b1000000000;
        //long类型的结尾需要加上L
        long l = 90000000000000000L;

        System.out.println(i + "\t" + i2 +"\t"+ i3 +"\t"+ i4 +"\t"+ i5 +"\t"+ l +"\t");


        //浮点数的定义
        float f1 = 3.14f;
        //科学计数法表示 3.13x10^38次
        float f2 = 3.13e38f;
        double d = 1.34e30;
        double d2 = -1.23;
        //科学计数法表示 4.8x10^-321次
        double d3 = 4.8e-321;


        //布尔类型
        boolean b1 = true;
        boolean b2 = false;

        boolean isGreater = 5 > 3;
        int age = 12;
        boolean isAdult = age > 18;

        //字符类型
        char a = 'A';
        char zh = '中';
        System.out.println(a);
        System.out.println(zh);


        //除了上述基本类型的变量，剩下的都是引用类型。
        // 例如，引用类型最常用的就是String字符串：

        //引用类型
        String s = "hello";

        //常量
        //常量在定义时进行初始化后就不可再次赋值，
        // 再次赋值会导致编译错误。


        final double PI = 3.14;
        double r = 5.0;
        double area = PI * r * r;

        //PI = 300;// compile error!


        //var关键字
        //有些时候，类型的名字太长，写起来比较麻烦。例如：
        StringBuilder sb = new StringBuilder();
        //这个时候，如果想省略变量类型，可以使用var关键字：
//        var sb2 = new StringBuilder();



        //定义变量时，要遵循作用域最小化原则，
        //尽量将变量定义在尽可能小的作用域，
        //并且，不要重复使用变量名。



    }
}