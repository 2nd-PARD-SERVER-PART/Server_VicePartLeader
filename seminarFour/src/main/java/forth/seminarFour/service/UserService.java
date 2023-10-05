package forth.seminarFour.service;


import forth.seminarFour.dto.ResponseDto;
import forth.seminarFour.dto.SignInDto;
import forth.seminarFour.dto.SignUpDto;
import forth.seminarFour.entity.UserEntity;
import forth.seminarFour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//1
    public ResponseDto<SignUpDto> signUp(SignUpDto dto){

        UserEntity user = new UserEntity(dto);
        String userEmail = dto.getUserEmail();
        try {
            if(userRepository.existsByUserEmail(userEmail)){
                return ResponseDto.setFailed("이미 존재하는 아이디 입니다.");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
        try{
            userRepository.save(user);
            return ResponseDto.setSuccess("성공했음", dto);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }
//2
    public ResponseDto<List<UserEntity>> findAll(){
        List<UserEntity> users;
        try {
            users = userRepository.findAll();
            return ResponseDto.setSuccess("find Success", users);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }
    public ResponseDto<UserEntity> findOne(Integer userNum){
        UserEntity user;
        try{
            user = userRepository.findById(userNum).get();
            return ResponseDto.setSuccess("find One", user);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB 오류");
        }
    }
    @Transactional //원래 save로 해줘야 하는데 이게 자동적으로 user의 변경을 감지하고 넣어줌
    public ResponseDto<UserEntity> updateOne(Integer userNum, SignUpDto dto){
        UserEntity user;
        try {
            user = userRepository.findById(userNum).get();
            if (dto.getUserEmail() != null && !dto.getUserEmail().isEmpty()) user.setUserEmail(dto.getUserEmail());
            if (dto.getUserPassword() != null && !dto.getUserPassword().isEmpty())user.setUserPassword(dto.getUserPassword());
            return ResponseDto.setSuccess("update One", user);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }

    public ResponseDto<?> deleteUser(Integer userNum){
        try {
            if (userRepository.existsById(userNum)) {
                userRepository.deleteById(userNum);
                return ResponseDto.setSuccess("Board Delete Success!", null);
            } else {
                return ResponseDto.setFailed("Board Not Found");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }

    public ResponseDto<String> signIn(SignInDto dto){
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        try{
            boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
            if(!existed) return ResponseDto.setFailed("존재하지 않는 userEmail");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
        return  ResponseDto.setSuccess("로그인을 축하드립니다.", userEmail);
    }

}
