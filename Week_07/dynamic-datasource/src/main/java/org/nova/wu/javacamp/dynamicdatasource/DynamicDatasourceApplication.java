package org.nova.wu.javacamp.dynamicdatasource;

import org.nova.wu.javacamp.dynamicdatasource.routing.RoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DynamicDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceApplication.class, args);
	}


	/**
	 * Master data source.
	 */
	@Bean("masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * Slave (read only) data source.
	 */
	@Bean("slaveDataSource")
	@ConfigurationProperties(prefix = "spring.ro-datasource")
	DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	DataSource primaryDataSource(
			@Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
			@Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource
	) {
		Map<Object, Object> map = new HashMap<>();
		map.put("masterDataSource", masterDataSource);
		map.put("slaveDataSource", slaveDataSource);
		RoutingDataSource routing = new RoutingDataSource();
		routing.setTargetDataSources(map);
		routing.setDefaultTargetDataSource(masterDataSource);
		return routing;
	}


}
