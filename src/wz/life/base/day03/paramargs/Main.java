package wz.life.base.day03.paramargs;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/30 12:17 上午
 */
public class Main {
    public static void main(String[] args) {

        for(String arg : args){
            if ("-version".equals(arg)){
                System.out.printf("v 1.0");
                break;
            }
        }


    }
}
