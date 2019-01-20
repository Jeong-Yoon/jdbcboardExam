package my.examples.jdbcboard.exam;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import my.examples.jdbcboard.dto.Board;

import javax.sql.*;
import java.sql.*;

public class HikariCPExam {
    public static void main(String args[]){
        // src/main/resources 아래에 datasource.properties를 위치시킨다.
        // src/main/resources 이 경로도 CLASSPATH
        // classpath에 있는 자원을 읽어들이려면 / 로 시작한다.
        String configFile = "/datasource.properties";
        HikariConfig config = new HikariConfig(configFile);

        //        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=UTF-8");
//        config.setUsername("connect");
//        config.setPassword("connect");

        DataSource ds = new HikariDataSource(config);

        int start = 0;
        int limit = 3;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();

            if (conn != null)
                System.out.println("connection is ok");

            String sql = "SELECT b.seq,b.user_id,u.name,b.title,b.content,b.pr_no,b.re_depth,b.re_ord,b.reg_date,b.hit,b.del_yn " +
                    "FROM user u, board b WHERE u.id = b.user_id ORDER BY b.seq DESC LIMIT ?,?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
            ps.setInt(2, limit);

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            while(rs.next()){
                long id = rs.getLong(1);
                String userId = rs.getString(2);
                String userName = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                int prNo = rs.getInt(6);
                int reDepth = rs.getInt(7);
                int reOrd = rs.getInt(8);
                Date regdate = rs.getDate(9);
                int hit = rs.getInt(10);

                Board board = new Board(id,userId,userName,title,content,prNo,reDepth,reOrd,regdate,hit);
                System.out.println(board);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                rs.close();
            }catch(Exception ignore){}
            try{
                ps.close();
            }catch(Exception ignore){}
            try{
                conn.close();
            }catch(Exception ignore){}
        }

    }
}