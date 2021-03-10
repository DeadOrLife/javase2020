package wz.life.collection.day01.writeequalsandhashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @DESCRIPTION 编写equals和hashcode
 * @AUTHOR: jamesbean
 * @DATE: 2021/3/10 10:26 下午
 */
public class Main {

    public static void main(String[] args) {

        //两个key应该是内容相同，但不一定是同一个对象
        Map<String,Integer> map = new HashMap<>();
        String key1 = "a";
        map.put(key1,123);

        String key2 = new String("a");
        map.get(key2);
        System.out.println(map.get(key2));
        System.out.println(key1 == key2);
        System.out.println(key1.equals(key2));

//        作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
//
//        作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
//
//        如果两个对象相等，则两个对象的hashCode()必须相等；
//        如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
//        即对应两个实例a和b：
//
//        如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
//        如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。



//        如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
//        hashCode()方法编写得越好，HashMap工作的效率就越高。
//
//        小结
//        要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
//
//        一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
//
//        如果equals()返回true，则hashCode()返回值必须相等；
//
//        如果equals()返回false，则hashCode()返回值尽量不要相等。
//
//        实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。

    }
}
