package org.nova.wu.javacamp.dynamicdatasource;

import org.junit.jupiter.api.Test;
import org.nova.wu.javacamp.dynamicdatasource.annotation.RoutingWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class DynamicDatasourceApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	    selectAllFromMaster();
	    selectAllFromSlave();
	}

	@Test
	public Integer selectAllFromMaster(){
		int count = jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
		return count;
	}

	@Test
	@RoutingWith("slaveDataSource")
	public Integer selectAllFromSlave(){
		int count = jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
		return count;
	}

}
