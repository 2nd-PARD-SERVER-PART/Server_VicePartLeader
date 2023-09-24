package three.seminar.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloDto {
    private String userName;
    private int age;
}



//public class HelloDto {
//    private String userName;
//    private int age;
//
//    // 생성자 없음 NoArgsConstructor
//    public HelloDto() {
//        // 생성자를 수동으로 작성해야 함
//    }
//
//    // 모든 필드를 인자로 받는 생성자 AllArgsConstructor
//    public HelloDto(String userName, int age) {
//        this.userName = userName;
//        this.age = age;
//    }
//     Data
//    // userName 필드의 getter
//    public String getUserName() {
//        return userName;
//    }
//
//    // userName 필드의 setter
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    // age 필드의 getter
//    public int getAge() {
//        return age;
//    }
//
//    // age 필드의 setter
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    // equals 메서드 수동 작성
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        HelloDto helloDto = (HelloDto) o;
//
//        if (age != helloDto.age) return false;
//        return userName != null ? userName.equals(helloDto.userName) : helloDto.userName == null;
//    }
//
//    // hashCode 메서드 수동 작성
//    @Override
//    public int hashCode() {
//        int result = userName != null ? userName.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
//
//    // toString 메서드 수동 작성
//    @Override
//    public String toString() {
//        return "HelloDto{" +
//                "userName='" + userName + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
