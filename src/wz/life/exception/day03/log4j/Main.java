package wz.life.exception.day03.log4j;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @DESCRIPTION Log4j
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/2 11:14 下午
 */
public class Main {
    static Log log =  LogFactory.getLog(Main.class);

    /*
    * 前面介绍了Commons Logging，可以作为“日志接口”来使用。而真正的“日志实现”可以使用Log4j。

        Log4j是一种非常流行的日志框架，最新版本是2.x。

        Log4j是一个组件化设计的日志系统，它的架构大致如下：

        log.info("User signed in.");
         │
         │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
         ├──>│ Appender │───>│  Filter  │───>│  Layout  │───>│ Console  │
         │   └──────────┘    └──────────┘    └──────────┘    └──────────┘
         │
         │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
         ├──>│ Appender │───>│  Filter  │───>│  Layout  │───>│   File   │
         │   └──────────┘    └──────────┘    └──────────┘    └──────────┘
         │
         │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
         └──>│ Appender │───>│  Filter  │───>│  Layout  │───>│  Socket  │
             └──────────┘    └──────────┘    └──────────┘    └──────────┘
        当我们使用Log4j输出一条日志时，Log4j自动通过不同的Appender把同一条日志输出到不同的目的地。例如：

        console：输出到屏幕；
        file：输出到文件；
        socket：通过网络输出到远程计算机；
        jdbc：输出到数据库
        在输出日志的过程中，通过Filter来过滤哪些log需要被输出，哪些log不需要被输出。例如，仅输出ERROR级别的日志。

        最后，通过Layout来格式化日志信息，例如，自动添加日期、时间、方法名称等信息。

        上述结构虽然复杂，但我们在实际使用的时候，并不需要关心Log4j的API，而是通过配置文件来配置它。

        以XML配置为例，使用Log4j的时候，我们把一个log4j2.xml的文件放到classpath下就可以让Log4j读取配置文件并按照我们的配置来输出日志。下面是一个配置文件的例子：
    * */

    public static void main(String[] args) {
        log.info("111");
        log.error("111");
        log.warn("111");
    }

}
