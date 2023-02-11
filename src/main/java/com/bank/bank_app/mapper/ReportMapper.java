package com.bank.bank_app.mapper;

import com.bank.bank_app.model.dto.ReportResponse;
import com.bank.bank_app.model.entity.OperationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    List<ReportResponse> operationEntityToReportResponse(List<OperationEntity> operations);
}
