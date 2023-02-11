package com.bank.bank_app.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "operations")
public class OperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_generator")
    @SequenceGenerator(name = "operation_generator", sequenceName = "operation_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "cardId should not be null")
    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardEntity card;

    @NotNull(message = "atmId should not be null")
    @ManyToOne
    @JoinColumn(name = "atm_id")
    private AtmEntity atm;

    @NotNull(message = "amount should not be null")
    @Column(name = "amount")
    private Float amount;

    @CreationTimestamp
    private java.time.LocalDateTime operationDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
