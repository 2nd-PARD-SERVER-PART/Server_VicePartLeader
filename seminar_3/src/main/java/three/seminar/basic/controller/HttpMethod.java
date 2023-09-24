package three.seminar.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/mapping/users")
public class HttpMethod {
    @GetMapping
    public String user(){
        return "get users";
    }
    @PostMapping
    public String addUser(){
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId = " + userId;
    }
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId = " + userId;
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete userId = " + userId;
    }
}
