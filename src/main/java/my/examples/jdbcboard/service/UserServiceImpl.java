package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dao.UserDao;
import my.examples.jdbcboard.dao.UserDaoImpl;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtilHikari;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();
    private UserServiceImpl(){}

    public static UserService getInstance(){
        return instance;
    }

    @Override
    public void addUser(User user) {
        Connection conn = null;
        UserDao userDao = UserDaoImpl.getInstance();
        try {
            conn = DBUtilHikari.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            userDao.addUser(user);
            conn.commit();
        }catch (Exception e){
            DBUtilHikari.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtilHikari.close(conn);
        }
    }

    @Override
    public User getUser(String email) {
        User user = null;
        UserDao userDao = UserDaoImpl.getInstance();
        try(Connection conn = DBUtilHikari.getInstance().getConnection()) {
            ConnectionContextHolder.setConnection(conn);
            user = userDao.getUser(email);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
