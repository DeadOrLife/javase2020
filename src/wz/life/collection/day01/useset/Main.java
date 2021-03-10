package wz.life.collection.day01.useset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * 我们知道，Map用于存储key-value的映射，对于充当key的对象，是不能重复的，并且，不但需要正确覆写equals()方法，还要正确覆写hashCode()方法。
 *
 * 如果我们只需要存储不重复的key，并不需要存储映射的value，那么就可以使用Set。
 *
 * Set用于存储不重复的元素集合，它主要提供以下几个方法：
 *
 * 将元素添加进Set<E>：boolean add(E e)
 * 将元素从Set<E>删除：boolean remove(Object e)
 * 判断是否包含元素：boolean contains(Object e)
 *
 *        ┌───┐
 *        │Set│
 *        └───┘
 *          ▲
 *     ┌────┴─────┐
 *     │          │
 * ┌───────┐ ┌─────────┐
 * │HashSet│ │SortedSet│
 * └───────┘ └─────────┘
 *                ▲
 *                │
 *           ┌─────────┐
 *           │ TreeSet │
 *           └─────────┘
 *
 *  Set用于存储不重复的元素集合：
 *
 * 放入HashSet的元素与作为HashMap的key要求相同；
 * 放入TreeSet的元素与作为TreeMap的Key要求相同；
 * 利用Set可以去除重复元素；
 *
 * 遍历SortedSet按照元素的排序顺序遍历，也可以自定义排序算法。
 *
 * @DESCRIPTION 使用Set
 * @AUTHOR: jamesbean
 * @DATE: 2021/3/10 11:20 下午
 */
public class Main {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素

//        Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。
//
//        因为放入Set的元素和Map的key类似，都要正确实现equals()和hashCode()方法，否则该元素无法正确地放入Set。

//        Set接口并不保证有序，而SortedSet接口则保证元素是有序的：
//
//        HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
//        TreeSet是有序的，因为它实现了SortedSet接口。


        Set<String> set2 = new HashSet<>();
        set2.add("apple");
        set2.add("banana");
        set2.add("pear");
        set2.add("orange");
        for (String s : set2) {
            System.out.println(s);
        }

//        注意输出的顺序既不是添加的顺序，也不是String排序的顺序，在不同版本的JDK中，这个顺序也可能是不同的。

//        把HashSet换成TreeSet，在遍历TreeSet时，输出就是有序的，这个顺序是元素的排序顺序：
        Set<String> set3 = new TreeSet<>();
        set3.add("apple");
        set3.add("banana");
        set3.add("pear");
        set3.add("orange");
        for (String s : set3) {
            System.out.println(s);
        }

//        使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口，如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象。

    }
}
