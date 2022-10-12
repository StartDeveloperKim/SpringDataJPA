package springdatajpa.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateDto {

    private Long id;
    private String password;
    private String confirmPassword;
    private String nickname;
}
