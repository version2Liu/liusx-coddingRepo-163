package com.liusx.demoszret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:spring-ret-config.xml"})
public class DemoSzretApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSzretApplication.class, args);
    }

}
