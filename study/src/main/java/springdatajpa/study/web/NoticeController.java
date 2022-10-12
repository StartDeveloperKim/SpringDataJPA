package springdatajpa.study.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeController {

    private final NoticeService noticeService;


}
