package com.bank.bank_app.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class ClientDto {

    private String name;
    private String surname;
    private String passportNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
