package springdatajpa.study.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdatajpa.study.domain.user.User;
import springdatajpa.study.domain.user.UserRepository;
import springdatajpa.study.web.dto.UserRegisterDto;
import springdatajpa.study.web.dto.UserUpdateDto;

import static springdatajpa.study.domain.user.User.*;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserRegisterDto registerDto) {
        User user = createUser(registerDto);
        userRepository.save(user); // 엔티티를 저장
    }

    public void updateUser(Long id, UserUpdateDto updateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("멤버가 없습니다!!."));
        user.updateUser(updateDto); // 변경감지(Dirty Checking)을 통한 Update
    }
}
