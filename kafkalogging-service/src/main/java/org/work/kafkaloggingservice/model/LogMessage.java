package org.work.kafkaloggingservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "log_messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
}