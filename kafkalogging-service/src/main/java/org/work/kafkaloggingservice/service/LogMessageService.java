package org.work.kafkaloggingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.work.kafkaloggingservice.model.LogMessage;
import org.work.kafkaloggingservice.repository.LogMessageRepository;

@Service
@RequiredArgsConstructor
public class LogMessageService {

    private final LogMessageRepository logMessageRepository;

    @KafkaListener(topics = "log_topic", groupId = "log-group")
    public void consume(String message) {
        System.out.println("Consumed log message: " + message);
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage(message);
        logMessageRepository.save(logMessage);
    }
}
