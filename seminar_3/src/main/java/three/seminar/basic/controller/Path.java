package three.seminar.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import three.seminar.basic.dto.HelloDto;

@Slf4j
@RestController
public class Path {
    @GetMapping("mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data ){ // == @PathVariable String userId 서로 값이 같으면 생략가능
        log.info("mapping userId={}",data );
        return "userId = "+ data  ;
    }
    @GetMapping("mapping/users/{userId}/age/{age}")
    public String mappingPath(@PathVariable String userId, @PathVariable String age){ // == @PathVariable String userId 서로 값이 같으면 생략가능
        log.info("mapping userId={}, age={} ",userId, age );
        return "userId = "+ userId +", age = "+ age ;
    }
    //requestParam ?userName = rlagustmd &Age = 12
    @GetMapping("requestParam/users")
    public String mappingPath(@RequestParam(defaultValue = "HS")String name ,
                              @RequestParam(required = false) Integer age){ // int 쓸 경우 null 값일때 오류 발생
        log.info("RequestParam name={}, age={} ",name, age ); //변수명과 이름값이 같다면 @RequestParam 삭제가능
        return "name = "+ name +", age = "+ age ;
    }

    //포스트맨으로 JSON 형식으로 보내는 걸 의미

    @PostMapping("requestBody")
    public String requestBody(@RequestBody HelloDto helloDto){
        log.info("RequestParam name={}, age={} ",helloDto.getUserName(), helloDto.getAge() );
        return "name = "+ helloDto.getUserName() +", age = "+ helloDto.getAge();
    }

    @ResponseStatus(HttpStatus.CREATED) //여기서 상태 조절 가능
    @PostMapping("requestBody2")
    public HelloDto requestBody2(@RequestBody HelloDto helloDto){
        log.info("RequestParam name={}, age={} ",helloDto.getUserName(), helloDto.getAge() );
        return helloDto;
    }

    @GetMapping("response-body-json")
    public HelloDto responseBody(){
        HelloDto helloDto = new HelloDto();
        helloDto.setUserName("PARD");
        helloDto.setAge(2);
        return helloDto;
    }
}
