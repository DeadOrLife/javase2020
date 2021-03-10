package wz.life.generic.day02.writegeneric;

/**
 *
 * 编写泛型时，需要定义泛型类型<T>；
 *
 * 静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法；
 *
 * 泛型可以同时定义多种类型，例如Map<K, V>。
 *
 * @DESCRIPTION 泛型
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/7 11:48 下午
 */
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }

    //静态方法
//        编写泛型类时，要特别注意，泛型类型<T>不能用于静态方法。例如：


    //上述代码会导致编译错误，我们无法在静态方法create()的方法参数和返回类型上使用泛型类型T。
    // 对静态方法使用<T>:
//    public static  Pair<T> create(T first, T last) {
//        return new Pair<T>(first, last);
//    }

//    但实际上，这个<T>和Pair<T>类型的<T>已经没有任何关系了。



    //    对于静态方法，我们可以单独改写为“泛型”方法，只需要使用另一个类型即可。对于上面的create()静态方法，我们应该把它改为另一种泛型类型，例如，<K>：
// 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }

    //多个泛型类型
//    泛型还可以定义多种类型。例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>：
//    public class Pair<T, K> {
//        private T first;
//        private K last;
//        public Pair(T first, K last) {
//            this.first = first;
//            this.last = last;
//        }
//        public T getFirst() { ... }
//        public K getLast() { ... }
//    }

//    Java标准库的Map<K, V>就是使用两种泛型类型的例子。它对Key使用一种类型，对Value使用另一种类型。


}
