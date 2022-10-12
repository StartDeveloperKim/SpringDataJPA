package springdatajpa.study.init;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springdatajpa.study.domain.notice.Notice;
import springdatajpa.study.domain.user.User;
import springdatajpa.study.web.dto.NoticeRequestDto;
import springdatajpa.study.web.dto.UserRegisterDto;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    // 초기화 작업을 할 메서드에 적용된다.
    // 해당 어노테이션이 적용된 초기화 메서드는 WAS가 띄어질 때 실행된다.
    public void init() {
        initService.dbInit1();
    }
}

@Component
@Transactional
@RequiredArgsConstructor
class InitService {

    private final EntityManager em;

    public void dbInit1() {
        UserRegisterDto registerDto = new UserRegisterDto("kim", "0000", "김지현", "킹지현");
        User user = User.createUser(registerDto);
        em.persist(user);

        NoticeRequestDto noticeRequestDto = new NoticeRequestDto("안녕하세요", "넵");
        Notice notice = Notice.createNotice(noticeRequestDto, user);
        em.persist(notice);
    }
}
