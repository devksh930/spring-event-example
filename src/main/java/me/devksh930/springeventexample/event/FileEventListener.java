package me.devksh930.springeventexample.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileEventListener {

    @EventListener
    public void onFileEventHandler(FileEvent fileEvent) {
        log.info("file event recive type : {} , data : {}", fileEvent.getType(), fileEvent.getData());
    }
}
