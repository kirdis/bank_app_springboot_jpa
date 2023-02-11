package com.bank.bank_app.controller;

import com.bank.bank_app.model.dto.ReportResponse;
import com.bank.bank_app.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/{id}/{date}")
    public ResponseEntity<List<ReportResponse>> showReportForClient(@PathVariable Long id,
                                                                   @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(reportService.showReportForClient(id, date), HttpStatus.OK);
    }
}
