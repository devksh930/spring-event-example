package me.devksh930.springeventexample.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.devksh930.springeventexample.event.FileEvent;
import me.devksh930.springeventexample.event.FileEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
    private final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("파일 복사 완료");
            log.info("DB 파일 메타 정보 저장 완료");
            FileEvent completeEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(completeEvent);
        } catch (Exception e) {
            log.error("file upload fail", e);
            FileEvent errorEvent = FileEvent.toErrorEvent(data);
            fileEventPublisher.notifyError(errorEvent);
        }

    }
}
