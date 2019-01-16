package io.github.gkdlaos.springbootexample.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SetupConf implements ApplicationListener<ApplicationReadyEvent> {

	@Qualifier("jdbc")
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		jdbc.update("CREATE TABLE `USER`(USER_ID VARCHAR(50) PRIMARY KEY , PASSWORD VARCHAR(50), `NAME` VARCHAR(50));");
	}
}
