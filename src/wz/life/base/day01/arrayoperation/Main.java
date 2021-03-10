package wz.life.base.day01.arrayoperation;

/**
 *
 * 小结
 * 数组是同一数据类型的集合，数组一旦创建后，大小就不可变；
 *
 * 可以通过索引访问数组元素，但索引超出范围将报错；
 *
 * 数组元素可以是值类型（如int）或引用类型（如String），但数组本身是引用类型；
 *
 * @DESCRIPTION 数组类型
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/10 12:57 上午
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 1.数组类型
         *
         * Java的数组有几个特点：
         *
         * 数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
         * 数组一旦创建后，大小就不可改变。
         * 要访问数组中的某一个元素，需要使用索引。数组索引从0开始，例如，5个元素的数组，索引范围是0~4。
         *
         * 可以修改数组中的某一个元素，使用赋值语句，例如，ns[1] = 79;。
         *
         * 可以用数组变量.length获取数组大小：
         */
        int n1 = 68;
        int n2 = 79;
        int n3 = 91;
        int n4 = 85;
        int n5 = 62;

        // 5位同学的成绩:
        int[] ns = new int[5];
        ns[0] = 68;
        ns[1] = 79;
        ns[2] = 91;
        ns[3] = 85;
        ns[4] = 62;


        //也可以在定义数组时直接指定初始化的元素，
        // 这样就不必写出数组大小，而是由编译器自动推算数组大小。例如：

// 5位同学的成绩:
        int[] ns2 = new int[] { 68, 79, 91, 85, 62 };
        // 编译器自动推算数组大小为5
        System.out.println(ns2.length);

        //还可以进一步简写为：

        int[] ns3 = { 68, 79, 91, 85, 62 };

        // 5位同学的成绩:
        int[] ns4;
        ns4 = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns4.length); // 5
        ns4 = new int[] { 1, 2, 3 };
        System.out.println(ns4.length); // 3


        //这里注意到原来names[1]指向的字符串"XYZ"并没有改变，
        // 仅仅是将names[1]的引用从指向"XYZ"改成了指向"cat"，
        // 其结果是字符串"XYZ"再也无法通过names[1]访问到了。



        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?


    }
}
