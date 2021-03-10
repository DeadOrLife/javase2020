package wz.life.base.day04.scope.abc;

/**
 * public
 *
 * 定义为public的class、interface可以被其他任何类访问：
 *
 * 实际上，确切地说，private访问权限被限定在class的内部，而且与方法声明顺序无关。推荐把private方法放到后面，因为public方法定义了类对外提供的功能，阅读代码的时候，应该先关注public方法：
 *
 * @DESCRIPTION
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/7 11:38 下午
 */
public class Hello {



//    public void hello(){
//        this.hi();
//    }

    //可以被其他类调用 前提类能被访问到
//    public void hi(){
//
//    }

    //不能被其他类调用
//    private void hi(){
//
//    }

    // protected方法:
    protected void hi() {
    }

    /**
     * 在方法内部定义的变量称为局部变量，局部变量作用域从变量声明处开始到对应的块结束。方法参数也是局部变量。
     * 局部变量
     * 使用局部变量时，应该尽可能把局部变量的作用域缩小，尽可能延后声明局部变量。
     *
     * 我们观察上面的hi()方法代码：
     *
     * 方法参数name是局部变量，它的作用域是整个方法，即①～⑩；
     *
     * 变量s的作用域是定义处到方法结束，即②～⑩；
     *
     * 变量len的作用域是定义处到方法结束，即③～⑩；
     *
     * 变量p的作用域是定义处到if块结束，即⑤～⑨；
     *
     * 变量i的作用域是for循环，即⑥～⑧。
     *
     */
    void hih(String name){//1
        String s = name.toLowerCase();//2
        int len = s.length();//3
        if(len < 10){//4
            int p = 10 - len;//5
            for(int i=0;i<10;i++){//6
                System.out.println();//7
            }//8
        }//9
    }//10
}
