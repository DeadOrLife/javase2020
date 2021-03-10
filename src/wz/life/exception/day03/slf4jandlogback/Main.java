package wz.life.exception.day03.slf4jandlogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * SLF4J和Logback可以取代Commons Logging和Log4j；
 *
 * 始终使用SLF4J的接口写入日志，使用Logback只需要配置，不需要修改代码。
 *
 * @DESCRIPTION
 * @AUTHOR: jamesbean
 * @DATE: 2021/1/3 12:00 上午
 */
public class Main {

    //如何使用SLF4J？它的接口实际上和Commons Logging几乎一模一样：
    static  final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        /*
        *
        * 前面介绍了Commons Logging和Log4j这一对好基友，它们一个负责充当日志API，一个负责实现日志底层，搭配使用非常便于开发。

            有的童鞋可能还听说过SLF4J和Logback。这两个东东看上去也像日志，它们又是啥？

            其实SLF4J类似于Commons Logging，也是一个日志接口，而Logback类似于Log4j，是一个日志的实现。

            为什么有了Commons Logging和Log4j，又会蹦出来SLF4J和Logback？这是因为Java有着非常悠久的开源历史，不但OpenJDK本身是开源的，而且我们用到的第三方库，几乎全部都是开源的。开源生态丰富的一个特定就是，同一个功能，可以找到若干种互相竞争的开源库。

            因为对Commons Logging的接口不满意，有人就搞了SLF4J。因为对Log4j的性能不满意，有人就搞了Logback。

            我们先来看看SLF4J对Commons Logging的接口有何改进。在Commons Logging中，我们要打印日志，有时候得这么写：
        * */
//        int score = 99;
//        p.setScore(score);
//        log.info("Set score " + score + " for Person " + p.getName() + " ok.");

        //拼字符串是一个非常麻烦的事情，所以SLF4J的日志接口改进成这样了：
//        int score = 99;
//        p.setScore(score);
//        logger.info("Set score {} for Person {} ok.", score, p.getName());
        //我们靠猜也能猜出来，SLF4J的日志接口传入的是一个带占位符的字符串，用后面的变量自动替换占位符，所以看起来更加自然。

        logger.info("info, hello {}", "slf4j");
        logger.error("error");
        logger.warn("error");

    }

}
