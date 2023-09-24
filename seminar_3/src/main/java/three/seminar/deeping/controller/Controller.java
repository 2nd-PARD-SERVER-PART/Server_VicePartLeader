package three.seminar.deeping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import three.seminar.deeping.repository.UserRepository;
import three.seminar.deeping.user.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    private final UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @PostMapping("/add")
//    public String UserAdd(@RequestParam Integer stuNum, @RequestParam String stuName) {
//        User user = new User();
//        user.setStuNum(stuNum);
//        user.setStuName(stuName);
//        userRepository.save(user);
//        return "더해짐";
//    }

    @PostMapping("/add/{stuNum}/Name/{stuName}")
    public String UserAdd(@PathVariable Integer stuNum , @PathVariable String stuName){
        User user = new User();
        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "추가완료";
    }

    @PostMapping("/add")
    public String UserAdd(@RequestBody User user) {
        userRepository.save(user);
        return "ㅊㄱ";
    }

    @GetMapping("/add")
    public List<User> UserFind() {
        List<User> students = userRepository.findAll();
        return students;
    }

    @GetMapping("/findOne/{stuNum}")
    public User UserFindOne(@PathVariable Integer stuNum) {
        User user = userRepository.findById(stuNum);
        return user;
    }

    @PatchMapping("/update/{stuNum}")
    public String UserUpdate(@PathVariable Integer stuNum ,@RequestBody User user) {
        userRepository.update(stuNum,user);
        return "교체완료";
    }

    @DeleteMapping("/delete/{stuNum}")
    public String UserDelete(@PathVariable Integer stuNum) {
        userRepository.delete(stuNum);
        return "삭제완료";
    }

}
