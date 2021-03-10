package wz.life.reflection.day02.dynamicproxy;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/5 12:46 上午
 */
public class HelloWorld implements Hello{

    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }
}
