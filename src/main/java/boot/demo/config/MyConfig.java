package boot.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration       :表明当前类为配置类
 *      @Bean    ：代替原配置文件中的<bean></bean>标签
 *
 *   @ImportResources     ：导入spring的配置文件，从其中获取值。
 *                标注在配置类上，注入组件
 */
@Configuration
public class MyConfig {

    @Bean  //将方法的返回值添加到容器中，容器中默认id为方法名
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组件了。。。");
        return new HelloService();
    }


}
