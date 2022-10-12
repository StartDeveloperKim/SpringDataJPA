package springdatajpa.study.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdatajpa.study.domain.notice.Notice;
import springdatajpa.study.domain.notice.NoticeRepository;
import springdatajpa.study.domain.user.UserRepository;
import springdatajpa.study.web.dto.NoticeResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResponseDto> findNoticeResponseDto() {
        List<Notice> result = noticeRepository.findAll();

        return result.stream().map(NoticeResponseDto::new)
                .collect(Collectors.toList());
    }
}
