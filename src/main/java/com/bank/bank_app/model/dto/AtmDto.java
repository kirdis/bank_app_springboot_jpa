package com.bank.bank_app.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AtmDto {
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
