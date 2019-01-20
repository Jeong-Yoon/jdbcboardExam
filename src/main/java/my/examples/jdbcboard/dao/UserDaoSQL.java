package my.examples.jdbcboard.dao;

public class UserDaoSQL {
    public static final String INSERT = "INSERT INTO user (name, email, user_pwd) VALUES (?, ?, ?)";
    public static final String SELECT_BY_EMAIL = "SELECT id, name, user_pwd FROM user WHERE email = ?";
}