package io.github.gkdlaos.springbootexample.model;

import java.util.Objects;

public class User {
	private String userId;
	private String password;
	private String name;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(userId, user.userId) && Objects.equals(password, user.password)
				&& Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, password, name);
	}

	@Override
	public String toString() {
		return "User{" + "userId='" + userId + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + '}';
	}
}
