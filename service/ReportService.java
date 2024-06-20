package com.myapp.service;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private UserService userService;

    public String generateAndSaveUserReport() throws JRException, FileNotFoundException {
        List<User> users = userService.getAllUsers();

        // Load JRXML file from the classpath
        InputStream resourceAsStream = getClass().getResourceAsStream("/reports/users_reports.jrxml");
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Report template not found in path: /users_reports.jrxml");
        }

        JasperReport jasperReport = JasperCompileManager.compileReport(resourceAsStream);

        // Convert List<User> to JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);

        Map<String, Object> parameters = new HashMap<>();

        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Define the output file path
        File outputFile = new File("/home/vvdn/Desktop/images", "user1_report.pdf");
        outputFile.getParentFile().mkdirs(); // Ensure the directory exists

        // Export to PDF
        JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(outputFile));

        return outputFile.getAbsolutePath(); // Return the file path
    }
}
