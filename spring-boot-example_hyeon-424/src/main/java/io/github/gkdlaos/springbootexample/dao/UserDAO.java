package io.github.gkdlaos.springbootexample.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.gkdlaos.springbootexample.model.User;
import rowMapper.UserMapper;

@Repository
public class UserDAO {

	@Qualifier("jdbc")
	@Autowired
	private JdbcTemplate jdbc;
	
	private RowMapper<User> rowMapper = new UserMapper();
	// Polymorphism 개념에 따라 UserMapper 객체를 RowMapper 타입의 참조변수로 참조하는 것이 가능함
	// Generic 개념에 따라 UserMapper 객체를 갖는 rowMapper 변수를  User 타입으로 지정하여 사용할 수 있음

	public void insert(User user) {
		jdbc.update("INSERT INTO USER (USER_ID, PASSWORD, NAME) VALUES (?,?,?)", user.getUserId(), user.getPassword(), user.getName());
	}

	public User getByUserId(String userId) {
		try {
			return jdbc.queryForObject("SELECT * FROM USER WHERE USER_ID=?", rowMapper, userId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<User> getAllUsers() {
		try {
			return jdbc.query("SELECT * FROM USER", rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}
}
