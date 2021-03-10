package wz.life.base.day05.packagetype;

/**
 *
 * 基本类型：byte，short，int，long，boolean，float，double，char
 *
 * 引用类型：所有class和interface类型
 *
 * 引用类型可以赋值为null，表示空，但基本类型不能赋值为null：
 *
 * 基本类型	对应的引用类型
 * boolean	java.lang.Boolean
 * byte	    java.lang.Byte
 * short	java.lang.Short
 * int	    java.lang.Integer
 * long	    java.lang.Long
 * float	java.lang.Float
 * double	java.lang.Double
 * char	j   ava.lang.Character
 *
 * Java核心库提供的包装类型可以把基本类型包装为class；
 *
 * 自动装箱和自动拆箱都是在编译期完成的（JDK>=1.5）；
 *
 * 装箱和拆箱会影响执行效率，且拆箱时可能发生NullPointerException；
 *
 * 包装类型的比较必须使用equals()；
 *
 * 整数和浮点数的包装类型都继承自Number；
 *
 * 包装类型提供了大量实用方法。
 *
 * @DESCRIPTION 包装类型
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/27 9:41 下午
 */
public class Main {

    public static void main(String[] args) {
        int i = 100;
        // 通过new操作符创建Integer实例(不推荐使用,会有编译警告):
        Integer n1 = new Integer(i);
        // 通过静态方法valueOf(int)创建Integer实例:
        Integer n2 = Integer.valueOf(i);
        // 通过静态方法valueOf(String)创建Integer实例:
        Integer n3 = Integer.valueOf("100");
        System.out.println(n3.intValue());


        //自动转换
        int x = n2.intValue();

        //所以，Java编译器可以帮助我们自动在int和Integer之间转型：
        Integer n = 100; // 编译器自动使用Integer.valueOf(int)
        int x2 = n; // 编译器自动使用Integer.intValue()

        //这种直接把int变为Integer的赋值写法，称为自动装箱（Auto Boxing），
        // 反过来，把Integer变为int的赋值写法，称为自动拆箱（Auto Unboxing）。

        //注意：自动装箱和自动拆箱只发生在编译阶段，目的是为了少写代码。

        //装箱和拆箱会影响代码的执行效率，因为编译后的class代码是严格区分基本类型和引用类型的。并且，自动拆箱执行时可能会报NullPointerException：


//        Integer n4 = null;
//        int i2 = n4;


        //所有的包装类型都是不变类。我们查看Integer的源码可知，它的核心代码如下：

        //对两个Integer实例进行比较要特别注意：绝对不能用==比较，
        // 因为Integer是引用类型，必须使用equals()比较：



        //仔细观察结果的童鞋可以发现，==比较，较小的两个相同的Integer返回true，
        // 较大的两个相同的Integer返回false，这是因为Integer是不变类，
        // 编译器把Integer x = 127;自动变为Integer x = Integer.valueOf(127);，
        // 为了节省内存，Integer.valueOf()对于较小的数，始终返回相同的实例，
        // 因此，==比较“恰好”为true，但我们绝不能因为Java标准库的Integer内部有缓存优化就用==比较，
        // 必须用equals()方法比较两个Integer。
        Integer xx = 127;
        Integer yy = 127;
        Integer mm = 99999;
        Integer nn = 99999;
        //包装类型间的相等判断应该用equals，而不是'=='
        System.out.println("x == y: " + (xx==yy)); // true
        System.out.println("m == n: " + (mm==nn)); // false
        System.out.println("x.equals(y): " + xx.equals(yy)); // true
        System.out.println("m.equals(n): " + mm.equals(nn)); // true


        //进制转换

        //字符串---》整数
        int x1 = Integer.parseInt("100");
        int x3 = Integer.parseInt("100", 16); // 256,因为按16进制解析

        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制

        //我们经常使用的System.out.println(n);是依靠核心库自动把整数格式化为10进制输出并显示在屏幕上，
        // 使用Integer.toHexString(n)则通过核心库自动把整数格式化为16进制。


        //Java的包装类型还定义了一些有用的静态变量
        boolean t = Boolean.TRUE;
        boolean f = Boolean.FALSE;
        //int最大值 最小值
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        //long类型占用的bit和byte数量
        int sizeOfLong = Long.SIZE;//64
        int bytesOfLong = Long.BYTES;//8  SIZE/BYTE.SIZE


        //最后，所有的整数和浮点数的包装类型都继承自Number，
        // 因此，可以非常方便地直接通过包装类型获取各种基本类型：
        // 向上转型为Number:
        Number num = new Integer(999);
        // 获取byte, int, long, float, double:
        byte bx = num.byteValue();
        int nx = num.intValue();
        long lnx = num.longValue();
        float fx = num.floatValue();
        double dx = num.doubleValue();


        //在Java中，并没有无符号整型（Unsigned）的基本数据类型。
        // byte、short、int和long都是带符号整型，最高位是符号位。
        // 而C语言则提供了CPU支持的全部数据类型，包括无符号整型。
        // 无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。
        //
        //例如，byte是有符号整型，范围是-128~+127，
        // 但如果把byte看作无符号整型，它的范围就是0~255。
        // 我们把一个负的byte按无符号整型转换为int：
        byte xc = -1;
        byte yc = 127;
        System.out.println(Byte.toUnsignedInt(xc)); // 255
        System.out.println(Byte.toUnsignedInt(yc)); // 127
    }
}
