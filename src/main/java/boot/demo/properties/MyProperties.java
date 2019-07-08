package boot.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties     ：告诉springBoot将本类中所有属性与配置文件中的配置进行绑定(只有该类是容器中的组件---Component方能使用)
 *      （prefix = "my1"）        :指定配置项
 */
@Component
@ConfigurationProperties(prefix = "my1")
public class MyProperties {
    private int age;
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
