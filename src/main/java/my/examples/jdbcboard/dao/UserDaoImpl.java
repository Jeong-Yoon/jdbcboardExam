package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao{
    private static UserDao instance = new UserDaoImpl();
    private UserDaoImpl(){}
    public static UserDao getInstance(){
        return instance;
    }

    @Override
    public void addUser(User user) {
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            //id, name, email, user_pwd
            try(PreparedStatement ps = conn.prepareStatement(UserDaoSQL.INSERT)){
                ps.setString(1,user.getName());
                ps.setString(2,user.getEmail());
                ps.setString(3, user.getPasswd());
                ps.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String email) {
        User user = null;
        Connection conn = ConnectionContextHolder.getConnection();
        try {
            try(PreparedStatement ps = conn.prepareStatement(UserDaoSQL.SELECT_BY_EMAIL)){
                ps.setString(1,email);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()){
                        //id, name, user_pwd
                        Long id = rs.getLong(1);
                        String name = rs.getString(2);
                        String passwd = rs.getString(3);

                        user = new User(id,name,passwd);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
