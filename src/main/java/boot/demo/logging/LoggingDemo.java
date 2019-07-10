package boot.demo.logging;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * springboot的日志默认配置：org.springframeworsk.boot:spring-boot    logging包下
 *                      如果想用logging自己的配置文件，只需把配置文件直接放在resources目录下
 *                       例：logback-spring.xml   logback.xml
 *                          log4j2-spring.xml    log4j.xml
 *                       推荐使用-spring作为文件名，
 *                          logback.xml ---日志框架识别加载
 *                          logback-spring.xml ---springboot加载，可以用到springProfile标签指定不同运行环境 适配不同输出配置
 *
 * 日志框架： 与JDBC和数据库相似，日志也分为日志抽象层和日志实现
 *
 *      抽象层：SLF4j
 *      实现：Log4j、Log4j2、Logback
 *
 *      SpringBoot 选用SLF4J和Logback
 *
 *      SLF4J的使用：
 *          在开发中，日志记录方法的调用，不应该直接调用日志实现类，而是调用抽象层的方法
 *          import org.slf4j.Logger;
 *          import org.slf4j.LoggerFactory;
 *
 *          public static void main(String[] args) {
 *              Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
 *              logger.info("I'm Logging~~~~~");
 *           }
 *
 *           注：每个日志实现框架都有自己的配置文件，虽然通过slf4j进行调用，但配置文件还是用日志实现框架的配置文件
 *
 *
 *  遗留问题：
 *
 *      1、（slf4j+logback）：spring（commons-logging）、hibernate（jboss-logging）......
 *          统一日志记录：
 *                  将系统中其他日志框架先排除
 *                  用中间包来替换原有日志框架
 *                  导入slf4j的其他实现
 *
 *                       commons-logging --- jcl-over-slf4j.jar
 *                       log4j---           log4j-over-slf4j.jar
 *
 *
 *      springboot日志关系：spring-boot-starter-->spring-boot-starter-logging
 *          总结：
 *              springboot 也是使用slf4j+logback实现日志记录
 *              springboot也把其他的日志都替换成了slf4j
 *              中间转换包，偷梁换柱
 *
 *              如果要引入其他框架？一定要把框架的默认日志移除：
 *
 *
 *      日志的使用：
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class LoggingDemo {


    @Test
    public void demo() {

        Logger logger = LoggerFactory.getLogger(getClass());
//       日志级别：trace<debug<info<warn<error
//        可以调整输出日志的级别，日志只会输出这个级别以后的高级别生效
//        logging.level
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }
}
