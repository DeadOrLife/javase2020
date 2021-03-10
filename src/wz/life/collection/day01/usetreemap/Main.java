package wz.life.collection.day01.usetreemap;

import java.util.Map;
import java.util.TreeMap;

/**
 * 我们已经知道，HashMap是一种以空间换时间的映射表，它的实现原理决定了内部的Key是无序的，即遍历HashMap的Key时，其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）。
 *
 * 还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap。
 *
 *
 *        ┌───┐
 *        │Map│
 *        └───┘
 *          ▲
 *     ┌────┴─────┐
 *     │          │
 * ┌───────┐ ┌─────────┐
 * │HashMap│ │SortedMap│
 * └───────┘ └─────────┘
 *                ▲
 *                │
 *           ┌─────────┐
 *           │ TreeMap │
 *           └─────────┘
 *
 *
 * SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；
 *
 * 作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；
 *
 * 要严格按照compare()规范实现比较逻辑，否则，TreeMap将不能正常工作。
 *
 * Integer.compare(int, int)
 *
 * @DESCRIPTION 使用TreeMap
 * @AUTHOR: jamesbean
 * @DATE: 2021/3/10 10:48 下午
 */
public class Main {

    public static void main(String[] args) {


//        SortedMap保证遍历时以Key的顺序来进行排序。
//        例如，放入的Key是"apple"、"pear"、"orange"，
//        遍历的顺序一定是"apple"、"orange"、"pear"，
//        因为String默认按字母排序：

        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear


//        使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
//
//        如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：

        Map<Person,Integer> map2 = new TreeMap<Person,Integer>();
        map2.put(new Person("TOM"),1);
        map2.put(new Person("BOB"),2);
        map2.put(new Person("LILY"),3);
        for (Person key :
             map2.keySet()) {
            System.out.println(key);
        }
        System.out.println(map2.get(new Person("BOB")));



    }
}

class Person implements Comparable{
    public String name;
    public Person(String name) {
        this.name = name;
    }


//    注意到Comparator接口要求实现一个比较方法，
//    它负责比较传入的两个元素a和b，如果a<b，则返回负数，通常是-1，
//    如果a==b，则返回0，如果a>b，则返回正数，通常是1。
//    TreeMap内部根据比较结果对Key进行排序。


    @Override
    public int compareTo(Object o) {
        return 1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
