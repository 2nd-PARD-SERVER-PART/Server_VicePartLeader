package three.seminar.deeping.user;

import lombok.Data;

@Data
public class User {
    private Integer stuNum;
    private String stuName;


    public User(String stuName, Integer stuNum) {
        this.stuName = stuName;
        this.stuNum = stuNum;
    }

    public User() {
    }
}
