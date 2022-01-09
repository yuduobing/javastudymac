package yun520.xyz.javastudy.手写Async异步注解;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Service {
    @Autowired
    private Thread01 thread01;
    @RequestMapping("test")
    public String Test(){
        log.info("<1>");
        thread01.asyncLog();
        log.info("<3>");
        return "test";
    }

}