package springdatajpa.study.web.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdatajpa.study.domain.notice.Notice;
import springdatajpa.study.domain.notice.NoticeRepository;
import springdatajpa.study.domain.user.User;
import springdatajpa.study.domain.user.UserRepository;
import springdatajpa.study.web.dto.NoticeDetailResponse;
import springdatajpa.study.web.dto.NoticeListResponse;
import springdatajpa.study.web.dto.NoticeRequestDto;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    // 전체 게시글을 반환한다.
    @Transactional(readOnly = true) // 읽기에 있어 성능을 높여준다.
    public List<NoticeListResponse> findNoticeListResponse() {
        List<Notice> result = noticeRepository.findAll();

        return result.stream().map(NoticeListResponse::new)
                .collect(Collectors.toList());
    }

    // 아이디를 통해 게시글 하나를 반환
    @Transactional(readOnly = true)
    public NoticeDetailResponse findNoticeById(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 게시글이 없습니다."));

        return new NoticeDetailResponse(notice);
    }

    public void saveNotice(NoticeRequestDto requestDto, String memberId) {
        User user = userRepository.findById(memberId);
        Notice notice = Notice.createNotice(requestDto, user);

        noticeRepository.save(notice);
    }

    public void updateNotice(NoticeRequestDto requestDto, Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 글이 없습니다."));

        notice.updateNotice(requestDto);
    }


}
