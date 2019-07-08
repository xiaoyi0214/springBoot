package boot.demo.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 *      ---@Controller      :配置controller注解
 *      ---@ResponseBody    ：controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常是json或xml
 *                          使用此注解之后不会再走试图处理器，而是直接将数据写入到输入流中
 *
 */

@RestController
public class HelloController {
}
