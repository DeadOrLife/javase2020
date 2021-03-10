package wz.life.collection.day01.writeequals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * 在List中查找元素时，List的实现类通过元素的equals()方法比较两个元素是否相等，因此，放入的元素必须正确覆写equals()方法，Java标准库提供的String、Integer等已经覆写了equals()方法；
 *
 * 编写equals()方法可借助Objects.equals()判断。
 *
 * 如果不在List中查找元素，就不必覆写equals()方法。
 *
 * @DESCRIPTION 编写equals方法
 * @AUTHOR: jamesbean
 * @DATE: 2021/3/7 11:50 下午
 */
public class Main  {

    public static void main(String[] args) {


        //List还提供了boolean contains(Object o)方法来判断List是否包含某个指定元素。
        // 此外，int indexOf(Object o)方法可以返回某个元素的索引，
        // 如果元素不存在，就返回-1。

//        List<String> list = List.of("A", "B", "C");
//        System.out.println(list.contains("C")); // true
//        System.out.println(list.contains("X")); // false
//        System.out.println(list.indexOf("C")); // 2
//        System.out.println(list.indexOf("X")); // -1


//        List<String> list = List.of("A", "B", "C");
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.contains(new String("C"))); // true or false?
        System.out.println(list.indexOf(new String("C"))); // 2 or -1?



        List<Person> list2 = new ArrayList<Person>();
        list2.add(new Person("Xiao Ming"));
        list2.add(    new Person("Xiao Hong"));
        list2.add(  new Person("Bob"));

        //不出意外，虽然放入了new Person("Bob")，但是用另一个new Person("Bob")查询不到，原因就是Person类没有覆写equals()方法。
        System.out.println(list.contains(new Person("Bob"))); // false

//        编写equals
//        如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：
//
//        自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
//        对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
//        传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
//        一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
//        对null的比较：即x.equals(null)永远返回false。


//        因此，我们总结一下equals()方法的正确编写方法：
//
//        先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
//        用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
//        对引用类型用Objects.equals()比较，对基本类型直接用==比较。
//        使用Objects.equals()比较两个引用类型是否相等的目的是省去了判断null的麻烦。两个引用类型都是null时它们也是相等的。
//
//        如果不调用List的contains()、indexOf()这些方法，那么放入的元素就不需要实现equals()方法。









    }
}

class Person {
    String name;
    public int age;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }
}