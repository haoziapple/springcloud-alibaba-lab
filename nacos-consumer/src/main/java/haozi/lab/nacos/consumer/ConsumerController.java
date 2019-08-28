package haozi.lab.nacos.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-28 14:16
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProviderClient providerClient;

    /**
     * http://localhost:8763/rest-provider
     *
     * @return
     */
    @GetMapping("/rest-provider")
    public String restProvider() {
        return restTemplate.getForObject("http://nacos-provider/hi?name=resttemplate", String.class);
    }

    /**
     * http://localhost:8763/feign-provider
     *
     * @return
     */
    @GetMapping("/feign-provider")
    public String feignProvider() {
        return providerClient.hi("feignClient");
    }


}
