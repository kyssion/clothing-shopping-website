package org.kys.clothing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@EnableHystrix
@MapperScan("classpath:org.kys.clothing.dataQuery")
public class OderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OderApplication.class);
    }
}
