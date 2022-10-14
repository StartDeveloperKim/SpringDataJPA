package springdatajpa.study.domain.notice;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import springdatajpa.study.domain.BaseTimeEntity;
import springdatajpa.study.domain.user.User;
import springdatajpa.study.web.dto.NoticeRequestDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Notice extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ColumnDefault("0")
    private int hit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //==생성자==//
    // private으로 설정함으로써 외부에서는 생성금지, 생성메서드를 통해서만 생성가능
    private Notice(NoticeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public Notice() {

    }

    //==생성 메서드==//
    public static Notice createNotice(NoticeRequestDto requestDto, User user) {
        Notice notice = new Notice(requestDto);
        notice.setUser(user);
        return notice;
    }

    //==연관관계 편의메서드==//
    private void setUser(User user) {
        this.user = user;
        user.getNotices().add(this);
    }

    //==업데이트 메서드==//
    public void updateNotice(NoticeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
