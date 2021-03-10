package wz.life.generic.day02.usegeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用泛型时，把泛型参数<T>替换为需要的class类型，例如：ArrayList<String>，ArrayList<Number>等；
 *
 * 可以省略编译器能自动推断出的类型，例如：List<String> list = new ArrayList<>();；
 *
 * 不指定泛型参数类型时，编译器会给出警告，且只能将<T>视为Object类型；
 *
 * 可以在接口中定义泛型类型，实现此接口的类必须实现正确的泛型类型。
 *
 * @DESCRIPTION 使用泛型
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/7 11:24 下午
 */
public class Main {

    public static void main(String[] args) {
        //使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object：
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        String first = (String) list.get(0);
        String secomd = (String) list.get(1);


        //无编译器警告:
        List<String> list2 = new ArrayList<String>();
        list2.add("Hello");
        list2.add("World");
        // 无强制转型:
        String first2 = list2.get(0);
        String second2 = list2.get(1);

        // 可以省略后面的Number，编译器可以自动推断泛型类型：
        List<Number> list3 = new ArrayList<>();

        /**泛型接口*/
//        除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口：
//        public interface Comparable<T> {
//            /**
//             * 返回负数: 当前实例比参数o小
//             * 返回0: 当前实例与参数o相等
//             * 返回正数: 当前实例比参数o大
//             */
//            int compareTo(T o);
//        }
        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));
        Person[] ps = new Person[] {
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));


    }
}

class Person implements Comparable<Person>{
        String name;
        int score;
    public Person(String name, int score) {
        this.name=name;
        this.score=score;
    }
    @Override
    public String toString() {
        return this.name + "," + this.score;
    }


    @Override
    public int compareTo(Person o) {
//        return this.name.compareTo(o.name);
        return new Integer(this.score).compareTo(new Integer(o.score));
    }
}
