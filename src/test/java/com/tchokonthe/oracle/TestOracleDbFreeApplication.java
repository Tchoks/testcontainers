package com.tchokonthe.oracle;

import org.springframework.boot.SpringApplication;


public class TestOracleDbFreeApplication {

    public static void main(String[] args) {
        SpringApplication.from(OracleDbFreeApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
