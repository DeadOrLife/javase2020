package wz.life.annotation.day01.definitionannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Java使用@interface定义注解：
 *
 * 可定义多个参数和默认值，核心参数使用value名称；
 *
 * 必须设置@Target来指定Annotation可以应用的范围；
 *
 * 应当设置@Retention(RetentionPolicy.RUNTIME)便于运行期读取该Annotation。
 *
 * @DESCRIPTION 使用注解
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/6 12:09 上午
 */
public class Main {
    public static void main(String[] args) {
//        如何定义Annotation
//        我们总结一下定义Annotation的步骤：
//
//        第一步，用@interface定义注解：
//
//        public @interface Report {
//        }
//        第二步，添加参数、默认值：
//
//        public @interface Report {
//            int type() default 0;
//            String level() default "info";
//            String value() default "";
//        }
//        把最常用的参数定义为value()，推荐所有参数都尽量设置默认值。
//
//        第三步，用元注解配置注解：
//
//        @Target(ElementType.TYPE)
//        @Retention(RetentionPolicy.RUNTIME)
//        public @interface Report {
//            int type() default 0;
//            String level() default "info";
//            String value() default "";
//        }
//        其中，必须设置@Target和@Retention，@Retention一般设置为RUNTIME，因为我们自定义的注解通常要求在运行期读取。一般情况下，不必写@Inherited和@Repeatable。
    }


}
