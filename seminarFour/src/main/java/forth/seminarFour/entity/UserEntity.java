package forth.seminarFour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import forth.seminarFour.dto.SignUpDto;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity {
    @Id //pk설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 늘어나서 자동적으로 번호를 매겨줌
    private int userNum;
    @Column(columnDefinition = "TEXT", nullable = false) //안하면 기본 값 varchar(255) //not null 설정
    private String userEmail;
    @Column(length = 20) // varchar(20)
    private String userPassword;

    public UserEntity(SignUpDto dto){
            this.userEmail = dto.getUserEmail();
            this.userPassword = dto.getUserPassword();
    }
}
