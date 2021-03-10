package wz.life.collection.day01.Iist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 有序列表
 * 我们考察List<E>接口，可以看到几个主要的接口方法：
 *
 * 在末尾添加一个元素：boolean add(E e)
 * 在指定索引添加一个元素：boolean add(int index, E e)
 * 删除指定索引的元素：int remove(int index)
 * 删除某个元素：int remove(Object e)
 * 获取指定索引的元素：E get(int index)
 * 获取链表大小（包含元素的个数）：int size()
 * 但是，实现List接口并非只能通过数组（即ArrayList的实现方式）来实现，另一种LinkedList通过“链表”也实现了List接口。在LinkedList中，它的内部每个元素都指向下一个元素：
 *
 * HEAD ──>│ A │ ●─┼──>│ B │ ●─┼──>│ C │ ●─┼──>│ D │   │
 *
 *
 *                  ArrayList	LinkedList
 * 获取指定元素	    速度很快	    需要从头开始查找元素
 * 添加元素到末尾	    速度很快	    速度很快
 * 在指定位置添加/删除	需要移动元素	不需要移动元素
 * 内存占用	        少	        较大
 *
 *
 * @DESCRIPTION List集合
 * @AUTHOR: jamesbean
 * @DATE: 2021/2/14 9:44 上午
 */
public class Main {

    public static void main(String[] args) {


        /**
         * List的特点
         * 可以重复添加同样的元素
         * */

        List<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        System.out.println(list.size());

        //List还允许添加null
        list.add(null);
        System.out.println(list.get(3));

//        创建List
//        除了使用ArrayList和LinkedList，我们还可以通过List接口提供的of()方法，根据给定元素快速创建List：
//
//        java9
//        List<Integer> list = List.of(1, 2, 5);
//        但是List.of()方法不接受null值，如果传入null，会抛出NullPointerException异常。

        //遍历List
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }

//        但这种方式并不推荐，一是代码复杂，二是因为get(int)方法只有ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢。
//
//        所以我们要始终坚持使用迭代器Iterator来访问List。Iterator本身也是一个对象，但它是由List的实例调用iterator()方法的时候创建的。Iterator对象知道如何遍历一个List，并且不同的List类型，返回的Iterator对象实现也是不同的，但总是具有最高的访问效率。
//
//        Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素。因此，使用Iterator遍历List代码如下：

        //变历List集合的时候 推荐使用迭代器
        for(Iterator<String> it = list.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

//        有童鞋可能觉得使用Iterator访问List的代码比使用索引更复杂。但是，要记住，通过Iterator遍历List永远是最高效的方式。并且，由于Iterator遍历是如此常用，所以，Java的for each循环本身就可以帮我们使用Iterator遍历。把上面的代码再改写如下：

        for (String s : list) {
            System.out.println(s);
        }

//        实际上，只要实现了Iterable接口的集合类都可以直接用for each循环来遍历，Java编译器本身并不知道如何遍历集合对象，但它会自动把for each循环变成Iterator的调用，原因就在于Iterable接口定义了一个Iterator<E> iterator()方法，强迫集合类必须返回一个Iterator实例。

        //List和Array转换  集合转数组
        //方法1： 调用toArray()方法
        System.out.println("集合转数组 toArray():");
        Object[] array = list.toArray();
        for (Object o: array
             ) {
            System.out.println(o);
        }
        //这种方法会丢失类型信息，所以实际应用很少。

        System.out.println("集合转数组 toArray(T[]):");
        //方法2：toArray(T[]) 传入一个类型相同的Array，List内部自动把元素复制到传入的Array中：
        String[] str = list.toArray(new String[]{});
        for (String s : str){
            System.out.println(s);
        }


//        注意到这个toArray(T[])方法的泛型参数<T>并不是List接口定义的泛型参数<E>，所以，我们实际上可以传入其他类型的数组，例如我们传入Number类型的数组，返回的仍然是Number类型：

//        List<Integer> list = List.of(12, 34, 56);
//        Number[] array = list.toArray(new Number[3]);
//        for (Number n : array) {
//            System.out.println(n);
//        }

//        但是，如果我们传入类型不匹配的数组，例如，String[]类型的数组，由于List的元素是Integer，所以无法放入String数组，这个方法会抛出ArrayStoreException。
//
//        如果我们传入的数组大小和List实际的元素个数不一致怎么办？根据List接口的文档，我们可以知道：
//
//        如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回；如果传入的数组比List元素还要多，那么填充完元素后，剩下的数组元素一律填充null。
//
//        实际上，最常用的是传入一个“恰好”大小的数组：

        String[] s = list.toArray(new String[list.size()]);


        //最后一种更简洁的写法是通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法：
//        String[] arr = list.toArray(String[]::new);

        //Array转换List 数组转集合
        String[] ar = {"1","2","3",null};
        //只读的list
        List<String> lsi = Arrays.asList(ar);
//        对只读List调用add()、remove()方法会抛出UnsupportedOperationException。

//        反过来，把Array变为List就简单多了，通过List.of(T...)方法最简单：
//
//        Integer[] array = { 1, 2, 3 };
//        List<Integer> list = List.of(array);
//        对于JDK 11之前的版本，可以使用Arrays.asList(T...)方法把数组转换成List。
//
//        要注意的是，返回的List不一定就是ArrayList或者LinkedList，因为List只是一个接口，如果我们调用List.of()，它返回的是一个只读List：





    }
}
