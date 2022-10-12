package springdatajpa.study.web.dto;

import lombok.Data;
import springdatajpa.study.domain.notice.Notice;

import java.time.LocalDateTime;

@Data
public class NoticeResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private String writer;
    private int hit;

    // 빌더 vs 팩토리
    public NoticeResponseDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.createDate = notice.getCreateDate();
        this.writer = notice.getUser().getNickname();
        this.hit = notice.getHit();
    }
}
