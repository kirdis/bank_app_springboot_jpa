package com.bank.bank_app.service;

import com.bank.bank_app.model.dto.ReportResponse;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    public List<ReportResponse> showReportForClient(long id, LocalDate date);
}
