package boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置类==配置文件，配置类也是容器中的一个组件 @Component
 *
 * 1、@SpringBootApplication   :Springboot的主配置类，运行该类的main方法来启动springboot
 *     --@Target({ElementType.TYPE})
 *       @Retention(RetentionPolicy.RUNTIME)
 *       @Documented
 *       @Inherited
 *       @SpringBootConfiguration    :springboot的配置类注解
 *         ---@Configuration:配置类注解
 *       @EnableAutoConfiguration    ：开启自动配置功能
 *          ---@AutoConfigurationPackage  自动配置包，将主配置类 所在包及所有子包 里的所有组件扫描进去
 *                  -----底层注解  @Import
 *          ---@Import({AutoConfigurationImportSelector.class})     ：导入自动配置类（xxxAutoConfiguration）组件，以全类名的方式返回，将组件配置好并添加到容器中
 *              通过SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
 *                  加载类路径下的  拿到"META-INF/spring.factories"中EnableAutoConfiguration.class;指定的值
 *
 *                  J2EE的整体解决方案都在AutoConfiguration包中
 *
 *       @ComponentScan(excludeFilters = {@Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
 *                                       @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class})})
 *
 *
 *
 * 2、 自动配置原理：
 *       SpringBoot启动时加载了主配置类，开启自动配置功能 @EnableAutoConfiguration
 *           @EnableAutoConfiguration 作用：
 *
 *              ---@AutoConfigurationPackage  自动配置包，将主配置类 所在包及所有子包 里的所有组件扫描进去
 *                  -----底层注解  @Import
 *              ---@Import({AutoConfigurationImportSelector.class})     ：导入自动配置类（xxxAutoConfiguration）组件，以全类名的方式返回，将组件配置好并添加到容器中
 *                      AutoConfigurationImportSelector.class:中
 *              	    List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);   获取候选的配置
 *                          getCandidateConfigurations（）方法中  SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),getBeanClassLoader());来从类路径下扫描jar包
 *                                                                                                 EnableAutoConfiguration.class;
 *                             将类路径下META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值加入到容器中
 *                              每一个自动配置类都进行自动配置功能
 *
 *
 *      以HttpEncodingAutoConfiguration为例，解释自动配置原理：  根据当前不同的条件，来判断是否生效。如果生效，用 @bean 给容器添加组件，组件的属性是从对应的properties文件中获取
 *                                                              这些类里面的被一个属性又和properties中属性绑定
             * @Configuration   ：配置类标志
             * @EnableConfigurationProperties(HttpProperties.class)     ：启动指定类的ConfigurationProperties功能
 *                 --- @ConfigurationProperties(prefix = "spring.http") ：可以发现该类上有ConfigurationProperties注解，从配置文件中获取指定的值和属性进行绑定
 *                                                                        所有配置文件中能配置的属性都在xxxProperties类中封装着，
 *                 --- public class HttpProperties {}
             * @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)    ：判断是否是web项目
 *                                                                                              spring底层有 @Conditional注解，根据不同的条件，满足条件后配置类的配置才生效
             * @ConditionalOnClass(CharacterEncodingFilter.class)                               ：判断是否有这个过滤器
             * @ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true)        ：判断配置文件中是否有这个配置，matchIfMissing = true  代表即使没有配置，也默认生效
 *
 *      总结： springboot启动时会加载大量的自动配置类，
 *            如果对应功能有默认的自动配置类，可以查看其中配置了那些组件，
 *            添加组件时会从其对应的properties类中获取属性，而我们在properties文件中就是指定这些属性的值
 *
 *            xxxxAutoConfiguration：自动配置类  --给容器中添加组件
 *            xxxxProperties ：封装配置文件中相关的属性
 *
 *
 *  3、@Conditional 条件注解：springboot中有其派生的各种注解：
 *          作用：必须是 @Conditionalxxxx 中指定的添加成立，才给容器中添加组件，配置的内容才生效
 *
 *  4、# 开启springboot的debug模式,启动时在控制台打印自动配置类
 *      debug=true
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
