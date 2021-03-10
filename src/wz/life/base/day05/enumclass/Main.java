package wz.life.base.day05.enumclass;

/**
 *
 * 为了让编译器能自动检查某个值在枚举的集合内，并且，
 * 不同用途的枚举需要不同的类型来标记，不能混用，
 * 我们可以使用enum来定义枚举类：
 *
 * 这就使得编译器可以在编译期自动检查出所有可能的潜在错误。
 *
 * enum类型
 * 通过enum定义的枚举类，和其他的class有什么区别？
 *
 * 答案是没有任何区别。enum定义的类型就是class，只不过它有以下几个特点：
 *
 * 定义的enum类型总是继承自java.lang.Enum，且无法被继承；
 * 只能定义出enum的实例，而无法通过new操作符创建enum的实例；
 * 定义的每个实例都是引用类型的唯一实例；
 * 可以将enum类型用于switch语句。
 *
 *
 * Java使用enum定义枚举类型，它被编译器编译为final class Xxx extends Enum { … }；
 *
 * 通过name()获取常量定义的字符串，注意不要使用toString()；
 *
 * 通过ordinal()返回常量定义的顺序（无实质意义）；
 *
 * 可以为enum编写构造方法、字段和方法
 *
 * enum的构造方法要声明为private，字段强烈建议声明为final；
 *
 * enum适合用在switch语句中。
 *
 * @DESCRIPTION enum 枚举
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/27 11:58 下午
 */
public class Main {

    public static void main(String[] args) {
        Weekdays day = Weekdays.SUN;
        if (day == Weekdays.SAT || day == Weekdays.SUN){
            System.out.println("work at home");
        }else{
            System.out.println("work at office");
        }

        if (day.equals(Weekdays.SAT) || day.equals(Weekdays.SUN)){
            System.out.println("work at home");
        }else{
            System.out.println("work at office");
        }


        //返回常量名，例如：
        String s = Weekdays.SUN.name(); // "SUN"

        System.out.println(day.name());

        //enum的比较
        //使用enum定义的枚举类是一种引用类型。
        // 前面我们讲到，引用类型比较，要使用equals()方法，如果使用==比较，
        // 它比较的是两个引用类型的变量是否是同一个对象。
        // 因此，引用类型比较，要始终使用equals()方法，但enum类型可以例外。

        //原因：
        // 这是因为enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较：


        //ordinal()
        //返回定义的常量的顺序，从0开始计数，例如：
        int n = Weekdays.MON.ordinal(); // 1
        System.out.println(n);

        //改变枚举常量定义的顺序就会导致ordinal()返回值发生变化。

        //的ordinal就是不同的。如果在代码中编写了类似if(x.ordinal()==1)这样的语句，
        // 就要保证enum的枚举顺序不能变。新增的常量必须放在最后。


        //但是，如果不小心修改了枚举的顺序，编译器是无法检查出这种逻辑错误的。
        // 要编写健壮的代码，就不要依靠ordinal()的返回值。因为enum本身是class，
        // 所以我们可以定义private的构造方法，并且，给每个枚举常量添加字段：


        Weekdays days = Weekdays.SUN;
        if (days.dayValue == 6 || days.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }

        //注意：判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()！
        //应为toString()可以被覆写，name()不行,因为是final定义的


        //switch
        //最后，枚举类可以应用在switch语句中。
        // 因为枚举类天生具有类型信息和有限个枚举常量，
        // 所以比int、String类型更适合用在switch语句中：

        Weekdays daysw = Weekdays.SUN;
        switch(daysw) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + daysw + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + daysw + ". Work at home!");
                break;
                //加上default语句，可以在漏写某个枚举常量时自动报错，从而及时发现错误。
            default:
                throw new RuntimeException("cannot process " + daysw);
        }

    }

}

enum Weekdays{
    //SUN, MON, TUE, WED, THU, FRI, SAT;
//    SUN(0), MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6);
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    //这样就无需担心顺序的变化，新增枚举常量时，也需要指定一个int值。
    public final int dayValue;
//    private Weekdays(int dayValue) {
//        this.dayValue = dayValue;
//    }

    private final String chinese;
    private Weekdays(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }


    //覆写toString()的目的是在输出时更有可读性。
    @Override
    public String toString() {
        return this.chinese;
    }

}



