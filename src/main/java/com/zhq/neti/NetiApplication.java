package com.zhq.neti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.zhq.neti")
public class NetiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetiApplication.class, args);
    }

}
