package wz.life.base.day04.scope.opq;

/**
 *
 * Java内建的访问权限包括public、protected、private和package权限；
 *
 * Java在方法内部定义的变量是局部变量，局部变量的作用域从变量声明开始，到一个块结束；
 *
 * final修饰符不是访问权限，它可以修饰class、field和method；
 *
 * 一个.java文件只能包含一个public类，但可以包含多个非public类。
 *
 * 如果不确定是否需要public，就不声明为public，即尽可能少地暴露对外的字段和方法。
 *
 * 把方法定义为package权限有助于测试，因为测试类和被测试类只要位于同一个package，测试代码就可以访问被测试类的package权限方法。
 *
 * 一个.java文件只能包含一个public类，但可以包含多个非public类。如果有public类，文件名必须和public类的名字相同。
 *
 * Java还提供了一个final修饰符。final与访问权限不冲突，它有很多作用。
 *
 * 用final修饰class可以阻止被继承：
 *
 * @DESCRIPTION final
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/8 12:09 上午
 */
public final class Hello {
    private int n = 0;
    protected void hi(int t){
        long i = t;
    }

    // 无法被覆写:
    protected final void hi() {
    }

    //用final修饰field可以阻止被重新赋值：
    private final int n2 = 0;
    protected void hih() {
//        this.n2 = 1; // error!
    }



}
