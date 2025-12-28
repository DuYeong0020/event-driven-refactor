package com.dudu.gamebounty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class GameBountyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameBountyApplication.class, args);
    }

}
