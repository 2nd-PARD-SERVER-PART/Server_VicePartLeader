package forth.seminarFour.controller;

import forth.seminarFour.dto.ResponseDto;
import forth.seminarFour.dto.SignInDto;
import forth.seminarFour.dto.SignUpDto;
import forth.seminarFour.entity.UserEntity;
import forth.seminarFour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
    final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signUp")
    public ResponseDto<SignUpDto> signUp(@RequestBody SignUpDto request){
        ResponseDto<SignUpDto> result = userService.signUp(request);
        return result;
    }


    @GetMapping("/findAll")
    public ResponseDto<List<UserEntity>> findAll(){
        ResponseDto<List<UserEntity>> result = userService.findAll();
        return result;
    }

    @GetMapping("/findOne/{userNum}")
    public ResponseDto<UserEntity> findOne(@PathVariable Integer userNum){
        ResponseDto<UserEntity> result = userService.findOne(userNum);
        return result;
    }

    @PutMapping("/update/{userNum}")
    public ResponseDto<UserEntity> update(@PathVariable Integer userNum, @RequestBody SignUpDto dto){
        ResponseDto<UserEntity> result = userService.updateOne(userNum, dto);
        return result;
    }

    @DeleteMapping("/delete/{userNum}")
    public ResponseDto<?> delete(@PathVariable Integer userNum){
        ResponseDto<?> result = userService.deleteUser(userNum);
        return result;
    }

    //signIn
    @PostMapping("/signIn")
    public ResponseDto<?> signIn(@RequestBody SignInDto dto){
        ResponseDto<?> result = userService.signIn(dto);
        return result;
    }
}
