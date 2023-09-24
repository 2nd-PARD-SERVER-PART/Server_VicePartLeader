package three.seminar.basic.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorld {
    @RequestMapping({"/hello-world", "/hello"})
    public String helloWorld(){
        log.info("hello-world");
        return "hello World!";
    }

}
