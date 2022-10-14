package springdatajpa.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springdatajpa.study.domain.notice.Notice;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeListResponse {

    // 2022-10-12의 고민
    /*
    * detail페이지가 아닌 게시글 리스트 페이지에 전달할 DTO를 설계해야한다.
    * 그래서 해당 DTO에 list를 변수로 넣어줄까 하는데 list에 넣는 객체를 내부 객체로
    * 생성해도 될까라는 생각이 든다. 이는 내일 고민해보자.
    * */

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int hit;

    public NoticeListResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.createDate = notice.getCreateDate();
        this.updateDate = notice.getUpdateDate();
        this.hit = notice.getHit();
    }
}
