package com.bank.bank_app.service;

import com.bank.bank_app.model.dto.ReportResponse;
import com.bank.bank_app.model.entity.OperationEntity;
import com.bank.bank_app.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.bank.bank_app.utils.Base64Converter.decodeFromBase64;
import static com.bank.bank_app.utils.CardNumberMask.maskCardNumber;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private OperationRepository operationRepository;

    /* @Autowired
    private ReportMapper reportMapper;*/
    @Override
    public List<ReportResponse> showReportForClient(long id, LocalDate date) {

        List<OperationEntity> operations = operationRepository.getOperationEntitiesByClientAndDate(id, date);

        //List<ReportResponse> reportResponses = operationMapper.operationEntityToReportResponse(operations);

        List<ReportResponse> reportResponses = operations.stream()
                .map(operation ->
                        new ReportResponse(
                                maskCardNumber(decodeFromBase64(operation.getCard().getCardNumber())),
                                operation.getAtm().getAddress(),
                                operation.getAmount(),
                                operation.getOperationDate()))
                .collect(Collectors.toList());
        return reportResponses;
    }
}
