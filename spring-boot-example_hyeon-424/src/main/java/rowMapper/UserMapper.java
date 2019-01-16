package rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.gkdlaos.springbootexample.model.User;

public class UserMapper implements org.springframework.jdbc.core.RowMapper<User> {
	// RowMapper Interface는 mapRow라는 추상메서드를 가짐

	@Override
	// 추상메서드를 Overriding할 때는 조상(RowMapper)의 메서드보다 넓은 범위의 접근 제어자를 지정해야 하기 때문에 public User ...
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		// ResultSet Interface의 getString 추상메서드를 가짐
		// getString 추상 메서드는 ResultSet이 갖고 있는 결과값(data table)에서 지정된 열(column)의 index를 문자열로 검색함
		user.setUserId(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setName(rs.getString(3));
		
		// getString으로 받은 데이터를 행(row)단위로 각각 받아 User의 userId, password, name로 return해줌으로써 rowMapper의 역할을 대체한다고 볼 수 있음
		return user;
		//return new User();
		
	}
}
