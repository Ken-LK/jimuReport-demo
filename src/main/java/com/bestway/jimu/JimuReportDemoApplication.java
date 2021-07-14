package com.bestway.jimu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.jeecg.modules.jmreport"})
public class JimuReportDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JimuReportDemoApplication.class, args);
    }

}
