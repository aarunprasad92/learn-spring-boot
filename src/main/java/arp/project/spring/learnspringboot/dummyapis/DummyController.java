package arp.project.spring.learnspringboot.dummyapis;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @RequestMapping("/hello-bean")
    public Hello helloBean() {
        return new Hello("Hello world");
    }

    @RequestMapping("/hello-path-param/{name}")
    public Hello helloBeanPathParam(@PathVariable String name) {
        return new Hello("Hello world, " + name);
    }

    @RequestMapping("/hello-path-param/{name}/message/{message}")
    public Hello helloBeanMultiplePathParam(@PathVariable String name, @PathVariable String message) {
        return new Hello(message + ", " + name);
    }
}
