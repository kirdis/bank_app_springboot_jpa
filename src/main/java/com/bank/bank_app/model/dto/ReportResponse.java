package com.bank.bank_app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ReportResponse {
    String cardNumber;
    String atmAddress;
    Float amount;
    LocalDateTime operationDate;
}
