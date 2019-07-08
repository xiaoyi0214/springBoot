package boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置类==配置文件，配置类也是容器中的一个组件 @Component
 *
 * @SpringBootApplication   :Springboot的主配置类，运行该类的main方法来启动springboot
 *    --@Target({ElementType.TYPE})
 *      @Retention(RetentionPolicy.RUNTIME)
 *      @Documented
 *      @Inherited
 *      @SpringBootConfiguration    :springboot的配置类注解
 *         ---@Configuration:配置类注解
 *      @EnableAutoConfiguration    ：开启自动配置功能
 *          ---@AutoConfigurationPackage  自动配置包，将主配置类 所在包及所有子包 里的所有组件扫描进去
 *                  -----底层注解  @Import
 *          ---@Import({AutoConfigurationImportSelector.class})     ：导入自动配置类（xxxAutoConfiguration）组件，以全类名的方式返回，将组件配置好并添加到容器中
 *              通过SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
 *                  加载类路径下的  拿到"META-INF/spring.factories"中EnableAutoConfiguration.class;指定的值
 *
 *                  J2EE的整体解决方案都在AutoConfiguration包中
 *
 *      @ComponentScan(excludeFilters = {@Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
 *                                       @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class})})
 *
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }


}
