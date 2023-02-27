package arp.project.spring.learnspringboot.dummyapis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @RequestMapping("/hello-bean")
    public Hello helloBean() {
        return new Hello("Hello world");
    }
}
