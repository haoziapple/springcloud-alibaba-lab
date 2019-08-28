package haozi.lab.nacos.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-28 14:10
 */
@RestController
@RefreshScope
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(ProviderController.class);

    /**
     * 似乎会注入系统变量：Administrator
     */
    @Value("${username}")
    private String username;

    @Value("${name:wanghao}")
    private String name;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "forezp", required = false) String name) {
        return "hi, this is nacos-provider: " + name;
    }

    @GetMapping
    public String getName() {
        return name;
    }
}
