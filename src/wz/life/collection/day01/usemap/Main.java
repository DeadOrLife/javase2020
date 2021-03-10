package wz.life.collection.day01.usemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @DESCRIPTION 使用Map
 * @AUTHOR: jamesbean
 * @DATE: 2021/3/8 11:57 下午
 */
public class Main {

    public static void main(String[] args) {
//        我们知道，List是一种顺序列表，如果有一个存储学生Student实例的List，要在List中根据name查找某个指定的Student的分数，应该怎么办？
//
//        最简单的方法是遍历List并判断name是否相等，然后返回指定元素：
//
//        List<Student> list = ...
//        Student target = null;
//        for (Student s : list) {
//            if ("Xiao Ming".equals(s.name)) {
//                target = s;
//                break;
//            }
//        }
//        System.out.println(target.score);
//        这种需求其实非常常见，即通过一个键去查询对应的值。使用List来实现存在效率非常低的问题，因为平均需要扫描一半的元素才能确定，而Map这种键值（key-value）映射表的数据结构，作用就是能高效通过key快速查找value（元素）。



        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        System.out.println(map2.get("apple")); // 123
        map2.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println(map2.get("apple")); // 789

//        重复放入key-value并不会有任何问题，
//        但是一个key只能关联一个value。在上面的代码中，
//        一开始我们把key对象"apple"映射到Integer对象123，
//        然后再次调用put()方法把"apple"映射到789，
//        这时，原来关联的value对象123就被“冲掉”了。
//        实际上，put()方法的签名是V put(K key, V value)，
//        如果放入的key已经存在，put()方法会返回被删除的旧的value，
//        否则，返回null。

//        始终牢记：Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。
//        此外，在一个Map中，虽然key不能重复，但value是可以重复的：
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("apple", 123);
//        map.put("pear", 123); // ok

        Map<String,Integer> map3 =new HashMap<>();
        map3.put("apple",123);
        map3.put("pear",123);
        map3.put("banana",123);
        for(String key : map3.keySet()){
            System.out.println(key+" = "+ map3.get(key));
        }

        for(Map.Entry<String,Integer> set : map3.entrySet()){
            System.out.println(set.getKey()+" = "+ set.getValue());
        }

//        Map和List不同的是，Map存储的是key-value的映射关系，
//        并且，它不保证顺序。在遍历的时候，
//        遍历的顺序既不一定是put()时放入的key的顺序，
//        也不一定是key的排序顺序。
//        使用Map时，任何依赖顺序的逻辑都是不可靠的。
//        以HashMap为例，假设我们放入"A"，"B"，"C"这3个key，
//        遍历的时候，每个key会保证被遍历一次且仅遍历一次，
//        但顺序完全没有保证，甚至对于不同的JDK版本，
//        相同的代码遍历的输出顺序都是不同的！

//        遍历Map时，不可假设输出的key是有序的！

        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("Bob", 78));
        list1.add(new Student("Alice", 85));
        list1.add(new Student("Brush", 66));
        list1.add(new Student("Newton", 99));
        Students holder = new Students(list1);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");

    }
}

class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
            score = findInList(name);
            if (score != null) {
                this.cache.put(name, score);
            }
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (Student ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
