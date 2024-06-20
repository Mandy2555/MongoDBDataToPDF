package com.myapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myapp.config.JobConfig;
import com.myapp.config.JobConfigService;
import com.myapp.config.QuartzConfig;

@RestController
@RequestMapping("/api/jobs")
public class JobConfigController {

    @Autowired
    private JobConfigService jobConfigService;

    @Autowired
    private QuartzConfig quartzConfig;

    @PostMapping
    public ResponseEntity<JobConfig> addJobConfig(@RequestBody JobConfig jobConfig) {
        JobConfig savedJobConfig = jobConfigService.saveJobConfig(jobConfig);
        quartzConfig.scheduleJob(savedJobConfig);  // Schedule the job immediately after adding
        return new ResponseEntity<>(savedJobConfig, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JobConfig> getJobConfigById(@PathVariable String id) {
        JobConfig jobConfig = jobConfigService.getJobConfigById(id);
        if (jobConfig != null) {
            quartzConfig.scheduleJob(jobConfig);  // Schedule the job based on the fetched configuration
            return new ResponseEntity<>(jobConfig, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
