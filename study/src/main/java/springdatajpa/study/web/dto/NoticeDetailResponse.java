package springdatajpa.study.web.dto;

import lombok.Data;
import springdatajpa.study.domain.notice.Notice;

import java.time.LocalDateTime;

@Data
public class NoticeDetailResponse {

    private String title;
    private String content;
    private LocalDateTime createDate;
    private String writer;

    // 빌더 vs 팩토리
    public NoticeDetailResponse(Notice notice) {
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.createDate = notice.getCreateDate();
        this.writer = notice.getUser().getNickname();
    }
}
