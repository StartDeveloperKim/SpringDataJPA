package springdatajpa.study.web.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdatajpa.study.web.dto.NoticeDetailResponse;
import springdatajpa.study.web.dto.NoticeListResponse;
import springdatajpa.study.web.dto.NoticeRequestDto;

import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    // 게시글 DTO를 상세 DTO오 리스트 DTO로 구분하자.
    @GetMapping
    public ResponseEntity<List<NoticeListResponse>> getNoticeList() {
        List<NoticeListResponse> result = noticeService.findNoticeListResponse();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeDetailResponse> getNotice(@PathVariable Long id) {
        NoticeDetailResponse result = noticeService.findNoticeById(id);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<String> postNotice(@RequestBody NoticeRequestDto requestDto,
                                             @RequestParam String userId) {
        noticeService.saveNotice(requestDto, userId);

        return ResponseEntity.ok("success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putNotice(@RequestBody NoticeRequestDto requestDto,
                                            @PathVariable Long id) {
        noticeService.updateNotice(requestDto, id);

        return ResponseEntity.ok().body("success");
    }
}
