package wz.life.generic.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型就是编写模板代码来适应任意类型；
 *
 * 泛型的好处是使用时不必对类型进行强制转换，它通过编译器对类型进行检查；
 *
 * 注意泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变！），但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）。
 *
 * @DESCRIPTION 什么是泛型
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/6 12:48 上午
 */
public class Main {

    public static void main(String[] args) {
//        编译器为了避免这种错误，根本就不允许把ArrayList<Integer>转型为ArrayList<Number>。
//        ArrayList<Integer>和ArrayList<Number>两者完全没有继承关系。
//        List<Number> integerList = new ArrayList<Integer>();


    }
}
