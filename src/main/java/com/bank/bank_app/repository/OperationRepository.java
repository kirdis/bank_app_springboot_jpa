package com.bank.bank_app.repository;

import com.bank.bank_app.model.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, Long> {
    @Query("SELECT opr" +
            " FROM OperationEntity opr" +
            " JOIN CardEntity crd" +
            " WHERE opr.card = crd" +
            " AND crd.client.id = :clientId" +
            " AND cast(opr.operationDate as LocalDate) = :date")
    List<OperationEntity> getOperationEntitiesByClientAndDate
            (@Param("clientId") Long clientId, @Param("date") LocalDate date);
}
