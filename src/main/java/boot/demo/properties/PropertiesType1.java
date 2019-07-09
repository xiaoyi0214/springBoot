package boot.demo.properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 小逸 on 2019/6/28.
 * @author 小逸
 *
 */
@RequestMapping("/properties")
@RestController
public class PropertiesType1 {
    private static final Logger log = LoggerFactory.getLogger(PropertiesType1.class);

    private  MyProperties myProperties;

    @Autowired
    public PropertiesType1(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    @GetMapping("/1")
    public MyProperties myProperties1() {
        log.info("=================================================================================================");
        log.info(myProperties.toString());
        log.info("=================================================================================================");
        return myProperties;
    }
}



