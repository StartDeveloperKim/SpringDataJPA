package springdatajpa.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoticeRequestDto {

    private String title;
    private String content;
}
