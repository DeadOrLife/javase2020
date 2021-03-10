package wz.life.exception.day01.throwanexception;

/**
 * 调用printStackTrace()可以打印异常的传播栈，对于调试非常有用；
 *
 * 捕获异常并再次抛出新的异常时，应该持有原始异常信息；
 *
 * 通常不要在finally中抛出异常。如果在finally中抛出异常，
 * 应该原始异常加入到原有异常中。调用方可通过Throwable.getSuppressed()获取所有添加的Suppressed Exception。
 *
 * @DESCRIPTION 抛出异常
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/1 11:38 下午
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //当某个方法抛出了异常时，如果当前方法没有捕获异常，
        // 异常就会被抛到上层调用方法，直到遇到某个try ... catch被捕获为止：

        //process1();

//        try {
//            process1();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //抛出异常
//        当发生错误时，例如，用户输入了非法的字符，我们就可以抛出异常。
//
//        如何抛出异常？参考Integer.parseInt()方法，抛出异常分两步：
//
//        创建某个Exception的实例；
//        用throw语句抛出。
//        下面是一个例子：



        // 捕获到异常并再次抛出时，一定要留住原始异常，否则很难定位第一案发现场！


        //如果我们在try或者catch语句块中抛出异常，finally语句是否会执行？例如：


        /*try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }*/

        //异常屏蔽
        //如果在执行finally语句时抛出异常，那么，catch语句的异常还能否继续抛出？例如：
        /*try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
            throw new IllegalArgumentException();
        }*/

//        这说明finally抛出异常后，原来在catch中准备抛出的异常就“消失”了，
//        因为只能抛出一个异常。没有被抛出的异常称为“被屏蔽”的异常（Suppressed Exception）。


//        在极少数的情况下，我们需要获知所有的异常。如何保存所有的异常信息？
//        方法是先用origin变量保存原始异常，然后调用Throwable.addSuppressed()，
//        把原始异常添加进来，最后在finally抛出：

        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }


    }


    static void process1() {
        process2();
        try {
            process3("s");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    static void process2() {
        Integer.parseInt(null); // 会抛出NumberFormatException
    }

    static void process3(String s) {
        if (s==null) {
            NullPointerException e = new NullPointerException();
            throw e;
        }
    }
//    实际上，绝大部分抛出异常的代码都会合并写成一行：
    /*void process3(String s) {
        if (s==null) {
            throw new NullPointerException();
        }
    }*/
}
