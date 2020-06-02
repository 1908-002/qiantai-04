package com.lkc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderShopApplication.class, args);
    }

}
