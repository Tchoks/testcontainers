package com.tchokonthe.oracle;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.oracle.OracleContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

@TestConfiguration
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    static OracleContainer oracleFreeContainer() {
        return new OracleContainer(DockerImageName.parse("gvenzl/oracle-free:23.5-slim-faststart"))
                .withStartupTimeout(Duration.ofMinutes(5))
                .withUsername("testuser")
                .withPassword("testpwd");
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("JDBC_URL", oracleFreeContainer()::getJdbcUrl);
        registry.add("USERNAME", oracleFreeContainer()::getUsername);
        registry.add("PASSWORD", oracleFreeContainer()::getPassword);
    }


}
