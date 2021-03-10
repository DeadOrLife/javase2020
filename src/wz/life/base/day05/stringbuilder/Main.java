package wz.life.base.day05.stringbuilder;

/**
 *
 * StringBuilder是可变对象，用来高效拼接字符串；
 *
 * StringBuilder可以支持链式操作，实现链式操作的关键是返回实例本身；
 *
 * StringBuffer是StringBuilder的线程安全版本，现在很少使用。
 *
 * @DESCRIPTION StringBuilder
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/25 12:14 上午
 */
public class Main {
    public static void main(String[] args) {


        //Java编译器对String做了特殊处理，使得我们可以直接用+拼接字符串。
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s = s + "," + i;
        }

        //虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，
        // 然后扔掉旧的字符串。这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。

        //为了能高效拼接字符串，Java标准库提供了StringBuilder，
        // 它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象：

        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s2 = sb.toString();
        System.out.println(s2);

        //StringBuilder还可以进行链式操作：
        StringBuilder sb2 = new StringBuilder(1024);
        sb2.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb2.toString());


        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());
    }




}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum ++;
        return this;
    }

    public int value() {
        return sum;
    }
}
