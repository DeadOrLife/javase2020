package wz.life.base.day04.scope.efg;

/**
 *
 * 最后，包作用域是指一个类允许访问同一个package的没有public、private修饰的class，以及没有public、protected、private修饰的字段和方法。
 * 注意，包名必须完全一致，包没有父子关系，com.apache和com.apache.abc是不同的包。
 *
 * @DESCRIPTION package
 * @AUTHOR: jamesbean
 * @DATE: 2020/12/8 12:02 上午
 */
public class Main {
    void foo() {
        // 可以访问package权限的类:
        Hello h = new Hello();
        // 可以调用package权限的方法:
        h.hi();
    }
}
