package org.nova.wu.javacamp.dynamicdatasourceshardingSphere;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DynamicDatasourceShardingSphereApplicationTests {

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
	public Integer selectAllFromSlave(){
		int count = jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
		return count;
	}
}
