package yun520.xyz.javastudy.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class a

{
    @GetMapping("/")
    public String GetMapping(){
        return "helloworld";
    }
}
