package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;
import my.examples.jdbcboard.util.DBUtilHikari;
import org.springframework.security.core.parameters.P;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImplHikari implements BoardDao {
    @Override
    public Board getBoard(Long idParam) {
        Board board = null; // return할 타입을 선언한다.

        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_ID)) {
                ps.setLong(1, idParam);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        Long userId = rs.getLong(2);
                        String userName = rs.getString(3);
                        String title = rs.getString(4);
                        String content = rs.getString(5);
                        int prNo = rs.getInt(6);
                        int reDepth = rs.getInt(7);
                        int reOrd = rs.getInt(8);
                        Date regdate = rs.getDate(9);
                        int hit = rs.getInt(10);

                        board = new Board(id, userId, userName, title, content, prNo, reDepth, reOrd, regdate, hit);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> list = new ArrayList<>();
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            Connection conn = ConnectionContextHolder.getConnection();
            if (conn != null) {
                System.out.println("conn ok!");
                System.out.println(conn.getClass().getName());
            }
            // b. SELECT SQL 준비 - Connection
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_PAGING)) {
                ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
                ps.setInt(2, limit);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        Long userId = rs.getLong(2);
                        String userName = rs.getString(3);
                        String title = rs.getString(4);
                        int prNo = rs.getInt(5);
                        int reDepth = rs.getInt(6);
                        int reOrd = rs.getInt(7);
                        Date regdate = rs.getDate(8);
                        int hit = rs.getInt(9);

                        Board board = new Board(id, userId, userName, title, prNo, reDepth, reOrd, regdate, hit);
                        list.add(board);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void addBoard(Board board) {
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT)) {
                ps.setLong(1, board.getUserId());
                ps.setString(2, board.getTitle());
                ps.setString(3, board.getContent());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getLastInsertId(){
        Long lastId = 0L;

        Connection conn = ConnectionContextHolder.getConnection();
        try {
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.GET_LAST_INSERT_ID)) {
                try(ResultSet rs = ps.executeQuery()) {
                    if (rs.next()){
                        lastId = rs.getLong(1);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lastId;
    }

    public void updateLastInsertId(Long id){ //lats_ 어쩌구를 받아와서 넣어주자.
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_LAST_INSERT_ID)){
                ps.setLong(1,id);
                ps.setLong(2,id);
                ps.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void updateHit(Long seq) {
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE)) {
                ps.setLong(1, seq);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBoard(Long id) {
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.DELETE)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyBoard(Board board, Long id) {
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.MODIFY)){
                ps.setString(1, board.getTitle());
                ps.setString(2, board.getContent());
                ps.setLong(3, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int listCnt() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int listCnt = 0;
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            conn = ConnectionContextHolder.getConnection();

            // b. SELECT SQL 준비 - Connection
            String sql = "SELECT count(id) FROM board";
            ps = conn.prepareStatement(sql);
            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            if (rs.next()) {
                listCnt = rs.getInt(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        } finally {
//            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
//            DBUtilHikari.close(rs, ps);
//        }

        return listCnt;
    }

    public int getTotalCount() {
        int total = 0;
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.GET_TOTAL_CNT)){
                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()) {
                        total = rs.getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void updateGroupSeqGt(int groupNo, int reOrd) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_GROUP_SEQ_GT);) {
                ps.setInt(1, groupNo);
                ps.setInt(2, reOrd);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void addReBoard(Board board) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT_RE)) {

                ps.setString(1, board.getTitle());
                ps.setLong(2, board.getUserId());
                ps.setString(3, board.getContent());
                ps.setInt(4, board.getPrNo());
                ps.setInt(5, board.getReOrd() + 1);
                ps.setInt(6, board.getReDepth() + 1);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}