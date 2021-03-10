package wz.life.reflection.day02.Inheritance;

/**
 * 通过Class对象可以获取继承关系：
 *
 * Class getSuperclass()：获取父类类型；
 * Class[] getInterfaces()：获取当前类实现的所有接口。
 * 通过Class对象的isAssignableFrom()方法可以判断一个向上转型是否可以实现。
 *
 * @DESCRIPTION 获取继承关系
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/5 12:30 上午
 */
public class Main {

    public static void main(String[] args) {

//        当我们获取到某个Class对象时，实际上就获取到了一个类的类型：
//        Class cls = String.class; // 获取到String的Class
//        还可以用实例的getClass()方法获取：
//        String s = "";
//        Class cls = s.getClass(); // s是String，因此获取到String的Class
//        最后一种获取Class的方法是通过Class.forName("")，传入Class的完整类名获取：
//        Class s = Class.forName("java.lang.String");
//        这三种方式获取的Class实例都是同一个实例，因为JVM对每个加载的Class只创建一个Class实例来表示它的类型。


        /**获取父类的Class*/
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
        //class java.lang.Number
        //class java.lang.Object
        //null
//        运行上述代码，可以看到，Integer的父类类型是Number，
//        Number的父类是Object，Object的父类是null。
//        除Object外，其他任何非interface的Class都必定存在一个父类类型。

        /**获取interface*/
//        由于一个类可能实现一个或多个接口，通过Class我们就可以查询到实现的接口类型。例如，查询Integer实现的接口：

        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i2 : is) {
            System.out.println(i2);
        }
        //interface java.lang.Comparable
//        要特别注意：getInterfaces()只返回当前类直接实现的接口类型，
//        并不包括其父类实现的接口类型：

        Class s2 = Integer.class.getSuperclass();
        Class[] is2 = s2.getInterfaces();
        for (Class i3 : is2) {
            System.out.println(i3);
        }
        //interface java.io.Serializable

//        Integer的父类是Number，Number实现的接口是java.io.Serializable。
//        此外，对所有interface的Class调用getSuperclass()返回的是null，获取接口的父接口要用getInterfaces()：

        System.out.println(java.io.DataInputStream.class.getSuperclass()); // java.io.FilterInputStream，因为DataInputStream继承自FilterInputStream
        System.out.println(java.io.Closeable.class.getSuperclass()); // null，对接口调用getSuperclass()总是返回null，获取接口的父接口要用getInterfaces()
//        如果一个类没有实现任何interface，那么getInterfaces()返回空数组。


        /**继承关系*/
//        当我们判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符：
        Object n3 = Integer.valueOf(123);
        boolean isDouble = n3 instanceof Double; // false
        boolean isInteger = n3 instanceof Integer; // true
        boolean isNumber = n3 instanceof Number; // true
        boolean isSerializable = n3 instanceof java.io.Serializable; // true
//        如果是两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom()：

// Integer i = ?
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
// Number n = ?
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
// Object o = ?
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
// Integer i = ?
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer




    }
}
