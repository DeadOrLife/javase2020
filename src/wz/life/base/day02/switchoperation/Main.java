package wz.life.base.day02.switchoperation;

/**
 * switch语句可以做多重选择，然后执行匹配的case语句后续代码；
 *
 * switch的计算结果必须是整型、字符串或枚举类型；
 *
 * 注意千万不要漏写break，建议打开fall-through警告；
 *
 * 总是写上default，建议打开missing default警告；
 *
 * 从Java 14开始，switch语句正式升级为表达式，不再需要break，并且允许使用yield返回值。
 *
 * 根据某个表达式的结果，分别去执行不同的分支。
 *
 * @DESCRIPTION switch
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/20 12:46 上午
 */
public class Main {

    public static void main(String[] args) {
        int option = 99;
        switch (option){
            case 1:
                System.out.println("selected 1");
                break;
            case 2:
                System.out.println("selected 2");
                break;
            case 3:
                System.out.println("selected 3");
                break;
            default:
                System.out.println("not selected");
        }


        switch (option){
            case 1:
                System.out.println("selected 1");
            case 2:
                System.out.println("selected 2");
            case 3:
                System.out.println("selected 3");
            default:
                System.out.println("not selected");
        }

        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
            case 3:
                System.out.println("Selected 2, 3");
                break;
            default:
                System.out.println("Not selected");
                break;
        }

        //switch语句还可以匹配字符串。字符串匹配时，是比较“内容相等”。例如：

        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("Selected apple");
                break;
            case "pear":
                System.out.println("Selected pear");
                break;
            case "mango":
                System.out.println("Selected mango");
                break;
            default:
                System.out.println("No fruit selected");
                break;
        }



        //switch表达式  java12
        //注意新语法使用->，如果有多条语句，
        // 需要用{}括起来。不要写break语句，
        // 因为新语法只会执行匹配的语句，没有穿透效应。


//        switch(fruit) {
//            case "apple" -> System.out.println("Selected apple");
//            case "pear" -> System.out.println("Selected pear");
//            case "mango" -> {
//                System.out.println("Selected mango");
//                System.out.println("Good choice!");
//            }
//            default -> System.out.println("No fruit selected");
//        }

//        int opt = switch (fruit) {
//            case "apple" -> 1;
//            case "pear", "mango" -> 2;
//            default -> 0;
//        }; // 注意赋值语句要以;结束
//        System.out.println("opt = " + opt);


        /**
         * yield
         * 大多数时候，在switch表达式内部，我们会返回简单的值。
         *
         * 但是，如果需要复杂的语句，
         * 我们也可以写很多语句，放到{...}里，然后，
         * 用yield返回一个值作为switch语句的返回值：
         */

//        int opt = switch (fruit) {
//            case "apple" -> 1;
//            case "pear", "mango" -> 2;
//            default -> {
//                int code = fruit.hashCode();
//                yield code; // switch语句返回值
//            }
//        };
//        System.out.println("opt = " + opt);


    }
}
