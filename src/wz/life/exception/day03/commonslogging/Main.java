package wz.life.exception.day03.commonslogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * 通过Commons Logging实现日志，不需要修改代码即可使用Log4j；
 *
 * 使用Log4j只需要把log4j2.xml和相关jar放入classpath；
 *
 * 如果要更换Log4j，只需要移除log4j2.xml和相关jar；
 *
 * 只有扩展Log4j时，才需要引用Log4j的接口（例如，将日志加密写入数据库的功能，需要自己开发）。
 *
 * Commons Logging是使用最广泛的日志模块；
 *
 * Commons Logging的API非常简单；
 *
 * Commons Logging可以自动检测并使用其他日志模块。
 *
 * @DESCRIPTION Commons Logging
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/2 10:32 下午
 */
public class Main {

    //使用Commons Logging时，如果在静态方法中引用Log，通常直接定义一个静态类型变量：
//    static final Log logs = LogFactory.getLog(Main.class);
    static final Log logs = LogFactory.getLog(Main.class);


    //注意到实例变量log的获取方式是LogFactory.getLog(getClass())，
    // 虽然也可以用LogFactory.getLog(Person.class)，
    // 但是前一种方式有个非常大的好处，就是子类可以直接使用该log实例。例如：

    static void foo(){
        logs.info("foo");
    }

    public static void main(String[] args) {
        /*
        * 和Java标准库提供的日志不同，Commons Logging是一个第三方日志库，它是由Apache创建的日志模块。

            Commons Logging的特色是，它可以挂接不同的日志系统，并通过配置文件指定挂接的日志系统。
            * 默认情况下，Commons Loggin自动搜索并使用Log4j（Log4j是另一个流行的日志系统），
            * 如果没有找到Log4j，再使用JDK Logging。

            使用Commons Logging只需要和两个类打交道，并且只有两步：

            第一步，通过LogFactory获取Log类的实例； 第二步，使用Log实例的方法打日志。

            示例代码如下：
        * */

        Log log = LogFactory.getLog(Main.class);
        log.info("start...");
        log.warn("end.");

        /*
        * Commons Logging定义了6个日志级别
        *
        * FATAL
        * ERROR
        * WARING
        * INGP
        * DEBIG
        * TRACE
        *
        * 默认级别是info
        *
        * */

        //此外，Commons Logging的日志方法，例如info()，
        // 除了标准的info(String)外，
        // 还提供了一个非常有用的重载方法：info(String, Throwable)，
        // 这使得记录异常更加简单：
        try {

        }catch (Exception e){
            log.error("xxxx",e);
            log.info("xxxx",e);
        }

    }
}
