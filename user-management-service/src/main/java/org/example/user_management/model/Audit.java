package org.example.user_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Audit {
    @Id
    private String id;
    private String action;
    private String performedBy;
    private LocalDateTime timestamp;
}
