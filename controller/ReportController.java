package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myapp.service.ReportService;

@RestController
@RequestMapping("/users/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/generateUserReport")
    public String generateUserReport() {
        try {
            reportService.generateAndSaveUserReport();
            return "User report generated successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to generate user report.";
        }
    }
}
