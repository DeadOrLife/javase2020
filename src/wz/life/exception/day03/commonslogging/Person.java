package wz.life.exception.day03.commonslogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @DESCRIPTION
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/2 11:10 下午
 */
public class Person {

   protected final Log log = LogFactory.getLog(getClass());
    void foo() {
        log.info("foo");
    }
}
/*
* 由于Java类的动态特性，子类获取的log字段实际上相当于LogFactory.getLog(Student.class)，
* 但却是从父类继承而来，并且无需改动代码。

此外，Commons Logging的日志方法，例如info()，
* 除了标准的info(String)外，
* 还提供了一个非常有用的重载方法：info(String, Throwable)，
* 这使得记录异常更加简单：
* */

// 在子类中使用父类实例化的log:
class Student extends Person {
    void bar() {
        log.info("bar");
    }
}
