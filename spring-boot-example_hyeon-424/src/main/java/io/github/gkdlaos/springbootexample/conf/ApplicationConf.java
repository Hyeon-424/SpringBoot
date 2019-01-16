package io.github.gkdlaos.springbootexample.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationConf {
	@Bean
	public JdbcTemplate jdbc() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:h2:mem:");
		return new JdbcTemplate(ds);
	}
}
