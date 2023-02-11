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
@Table(name = "atms")
public class AtmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atm_generator")
    @SequenceGenerator(name = "atm_generator", sequenceName = "atm_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Address should not be null")
    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public AtmEntity(Long id) {
        this.id = id;
    }
}
