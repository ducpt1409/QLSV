package com.ptd.qlsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages ={"com.ptd"} )
@EntityScan(basePackages = {"com.ptd.entity"})
public class QlsvApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlsvApplication.class, args);
    }

}
