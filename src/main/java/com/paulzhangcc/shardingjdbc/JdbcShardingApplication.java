package com.paulzhangcc.shardingjdbc;

import com.paulzhangcc.shardingjdbc.util.DataSourceUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.paulzhangcc.shardingjdbc.dao.mapper")

public class JdbcShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcShardingApplication.class, args);
    }
    @Bean
    public DataSource dataSource() throws SQLException {
        return DataSourceUtil.dataSource();
    }
}
