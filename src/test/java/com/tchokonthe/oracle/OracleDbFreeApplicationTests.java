//package com.tchokonthe.oracle;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//@SpringBootTest
//@Import(TestcontainersConfiguration.class)
//class OracleDbFreeApplicationTests {
//
//    @Autowired
//    private DataSource dataSource;
//
////    @Autowired
////    private JdbcTemplate jdbcTemplate;
////
////    @Autowired
////    private OracleDbFreeApplication.CustomerRepository customerRepository;
//
//
//
//    @Test
//    void spring_datasource_connection() throws SQLException {
//        try(Connection conn = dataSource.getConnection()) {
//            Statement stmt = conn.createStatement();
//            stmt.executeQuery("SELECT * FROM v$version");
//        }
//    }
//
//}
