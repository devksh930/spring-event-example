package me.devksh930.springeventexample.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void notifyComplete(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }

    public void notifyError(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }
}
