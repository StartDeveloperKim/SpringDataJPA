package springdatajpa.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterDto {

    private String id;
    private String password;
    private String name;
    private String nickname;
}
