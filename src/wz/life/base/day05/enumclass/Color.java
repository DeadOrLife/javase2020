package wz.life.base.day05.enumclass;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/27 11:13 下午
 */
public class Color {
    public static final String RED = "r";
    public static final String GREEN = "g";
    public static final String BLUE = "b";
}


//public enum Color {
//    RED, GREEN, BLUE;
//}

//public final class Color extends Enum { // 继承自Enum，标记为final class
//    // 每个实例均为全局唯一:
//    public static final Color RED = new Color();
//    public static final Color GREEN = new Color();
//    public static final Color BLUE = new Color();
//    // private构造方法，确保外部无法调用new操作符:
//    private Color() {}
//}
//
//所以，编译后的enum类和普通class并没有任何区别。但是我们自己无法按定义普通class那样来定义enum，必须使用enum关键字，这是Java语法规定的。
//
//        因为enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法：