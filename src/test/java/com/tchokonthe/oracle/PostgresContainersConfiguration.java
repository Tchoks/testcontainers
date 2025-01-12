package com.tchokonthe.oracle;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
class PostgresContainersConfiguration {

    @Bean
    @ServiceConnection
    static PostgreSQLContainer postgresContainer() {
        return new PostgreSQLContainer<>("postgres:13-alpine")
                .withDatabaseName("postgres")
                .withUsername("postgres")
                .withPassword("postgres");
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("JDBC_URL", postgresContainer()::getJdbcUrl);
        registry.add("USERNAME", postgresContainer()::getUsername);
        registry.add("PASSWORD", postgresContainer()::getPassword);
    }

}
