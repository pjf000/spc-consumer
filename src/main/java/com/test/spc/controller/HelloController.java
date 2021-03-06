package com.test.spc.controller;

import com.test.spc.service.HelloFeignService;
import com.test.spc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JeffPeng on 2018/3/26.
 */
@RestController
@RefreshScope
public class HelloController {
    @Autowired
    HelloService helloService;
    @Autowired
    HelloFeignService helloFeignService;

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name)+foo;
    }

    @RequestMapping(value = "/sayHi",method = RequestMethod.POST)
    public String sayHi(@RequestParam String name){
        return helloFeignService.sayHiFromClientOne(name)+"—feign—"+foo;
    }

}
