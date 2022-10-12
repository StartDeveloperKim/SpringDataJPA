package springdatajpa.study.web.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdatajpa.study.web.dto.UserRegisterDto;
import springdatajpa.study.web.dto.UserUpdateDto;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody UserRegisterDto registerDto) {
        log.info("/user Post API {}", registerDto.toString());

        userService.addUser(registerDto);
        return ResponseEntity.ok().body("User post success");
    }

    @PutMapping
    public ResponseEntity<String> putUser(@RequestBody UserUpdateDto updateDto) {
        log.info("/user Put API {}", updateDto.toString());

        userService.updateUser(updateDto.getId(), updateDto);
        return ResponseEntity.ok().body("User update success");
    }
}
