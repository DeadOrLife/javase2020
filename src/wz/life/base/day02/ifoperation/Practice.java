package wz.life.base.day02.ifoperation;

import java.util.Scanner;

/**
 * @DESCRIPTION 计算BMI
 * @AUTHOR: jamesbean
 * @DATE: 2020/10/20 12:34 上午
 */
public class Practice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("您的体重(kg)是：");
        Double weight = scanner.nextDouble();
        System.out.println("您的身高(m)是：");
        Double height = scanner.nextDouble();
//        Double weight = 60.0;
//        Double height = 1.7;
        System.out.println("BMI指数：");

        Double BMI = weight / (height*height);
        if (BMI < 18.5){
            System.out.println("过轻");
        }else if(BMI >=18.5 && BMI < 25){
            System.out.println("正常");
        }else if(BMI >= 25 && BMI < 28){
            System.out.println("过重");
        }else if(BMI >= 28 && BMI < 32){
            System.out.println("肥胖");
        }else {
            System.out.println("非常胖");
        }
    }
}
