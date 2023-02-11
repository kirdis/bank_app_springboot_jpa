package com.bank.bank_app.model.dto;

import com.bank.bank_app.model.entity.ClientEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CardDto {

    private String cardNumber;
    private ClientDto client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
