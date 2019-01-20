package my.examples.jdbcboard.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
//    private static final String driverClassname = "com.mysql.cj.jdbc.Driver"; // driver class이름도 JDBC Driver에 다르다.
//    private static final String driverURL = "jdbc:mysql://localhost:3306/boardexam?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
//    // driver URL형식 Database마다 다르다.
//    private static final String dbUserId = "admin";
//    private static final String dbUserPassword = "1234";

    private static HikariConfig config = null;
    private static DataSource ds = null;
    private static DBUtil instance = new DBUtil();

    private DBUtil(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/boardexam?useUnicode=true&characterEncoding=UTF-8&serverTimezone");
        config.setUsername("admin");
        config.setPassword("1234");

        ds = new HikariDataSource(config);
    }

    public static DBUtil getInstance(){
        return instance;
    }


    public static Connection getConnection(){
        Connection conn = null;
        try {
//            Class.forName(driverClassname); // driver class가 로딩.
//            conn = DriverManager.getConnection(driverURL, dbUserId, dbUserPassword);

            conn = ds.getConnection();
        }catch (Exception e){
            e.printStackTrace(); // 로그를 남기는 코드가 있어야 한다.
            throw new RuntimeException("DB를 연결할 수 없습니다.");
        }

        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn){
        // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
        try {
            rs.close();
        } catch (Exception ignore) {
        }
        close(ps, conn);
    }

    public static void close(PreparedStatement ps, Connection conn){
        try {
            ps.close();
        } catch (Exception ignore) {
        }
        try {
            conn.close();
        } catch (Exception ignore) {
        }
    }
}
