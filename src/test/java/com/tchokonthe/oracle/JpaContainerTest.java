package com.tchokonthe.oracle;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@ActiveProfiles("postgres")
@Sql("classpath:init.sql")
@Import(value = {PostgresContainersConfiguration.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaContainerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void should_return_customers() {
        List<Customer> customers = customerRepository.findAll();

        Assertions.assertThat(customers).isNotEmpty()
                .hasSize(2);
    }
}
