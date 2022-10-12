package springdatajpa.study.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springdatajpa.study.domain.BaseTimeEntity;
import springdatajpa.study.domain.notice.Notice;
import springdatajpa.study.web.dto.UserRegisterDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"id", "nickname"}
        )
})
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notice> notices = new ArrayList<>();

    private User(String id, String password, String name, String nickname) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    //==생성 메서드==//
    public static User createUser(UserRegisterDto registerDto) {
        return new User(registerDto.getId(), registerDto.getPassword(),
                registerDto.getName(), registerDto.getNickname());
    }

}
