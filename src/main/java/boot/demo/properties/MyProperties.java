package boot.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * 注入方式1： 默认从全局文件中获取值
 * @ConfigurationProperties     ：告诉springBoot将本类中所有属性与配置文件中的配置进行绑定(只有该类是容器中的组件---Component方能使用)
 *      （prefix = "my1"）        :指定配置项
 *
 *      批量注入属性文件，支持松散绑定，不支持SpEL，支持JSR303数据校验（@Validated），支持复杂类型封装
 *
 * 注入方式二：默认从全局文件中获取值
 * @value
 *
 *      单个指定，不支持松散绑定，支持SpEL（#{}），不支持数据校验，不支持复杂类型封装
 *
 * 配置文件注入数据校验
 *      在@ConfigurationProperties 注入中加入@Validated
 *
 *
 * @PropertiesSource（value = {"classpath:person.properties"}）   从指定文件中获取值
 *

 */
@Component
@ConfigurationProperties(prefix = "my1")
@Validated
public class MyProperties {
//    @Value("${my2.age}")
    private int age;
//    @Value("${my2.name}")
//    @Email    数据校验
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
