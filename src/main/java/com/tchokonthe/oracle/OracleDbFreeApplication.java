package com.tchokonthe.oracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJdbcRepositories
@EnableJpaRepositories(basePackages = "com.tchokonthe.oracle")
@EntityScan(basePackages = "com.tchokonthe.oracle")
@SpringBootApplication
@EnableAspectJAutoProxy
public class OracleDbFreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OracleDbFreeApplication.class, args);
    }

}
