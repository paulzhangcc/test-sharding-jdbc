package com.paulzhangcc.shardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.paulzhangcc.shardingjdbc.dao.mapper")
public class JdbcShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcShardingApplication.class, args);
	}

}
