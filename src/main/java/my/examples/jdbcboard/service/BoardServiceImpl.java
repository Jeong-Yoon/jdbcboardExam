package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImplHikari;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtilHikari;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    public static final int SIZE = 3;

    @Override
    public List<Board> getBoards(int start, int limit) {
        BoardDao boardDao = new BoardDaoImplHikari();
//        int start = page * SIZE - SIZE;
//        int limit = SIZE;

        List<Board> boards = new ArrayList<>();
        try(Connection conn = DBUtilHikari.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.getBoards(start, limit);
        }catch (Exception e){
            e.printStackTrace();
        }
        return boards;
    }

    @Override
    public Board getBoard(Long id) {
        Board board = null;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImplHikari();

        try {
            conn = DBUtilHikari.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            board = boardDao.getBoard(id);
            boardDao.updateHit(id);
            conn.commit();
        }catch (Exception e){
            DBUtilHikari.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtilHikari.close(conn);
        }
        return board;
    }

    @Override
    public void deleteBoard(Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImplHikari();

        try {
            conn = DBUtilHikari.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.deleteBoard(id);
            conn.commit();
        }catch (Exception e){
            DBUtilHikari.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtilHikari.close(conn);
        }
    }

    @Override
    public void addBoard(Board board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImplHikari();

        try {
            conn = DBUtilHikari.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.addBoard(board);
            Long id = boardDao.getLastInsertId();
            boardDao.updateLastInsertId(id);
            conn.commit();
        }catch (Exception e){
            DBUtilHikari.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtilHikari.close(conn);
        }
    }

    @Override
    public void modifyBoard(Board board, Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImplHikari();

        try {
            conn = DBUtilHikari.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.modifyBoard(board, id);
            conn.commit();
        }catch (Exception e){
            DBUtilHikari.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtilHikari.close(conn);
        }
    }

    @Override
    public int getTotalCount() {
        BoardDao boardDao = new BoardDaoImplHikari();
        int total = 0;

        try (Connection conn = DBUtilHikari.getInstance().getConnection()){
            ConnectionContextHolder.setConnection(conn);
            total = boardDao.getTotalCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }
}
