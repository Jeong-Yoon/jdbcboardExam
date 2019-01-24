//package my.examples.jdbcboard.dao;
//
//import my.examples.jdbcboard.dto.Board;
//import my.examples.jdbcboard.util.DBUtil;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BoardDaoImpl implements BoardDao {
//    @Override
//    public Board getBoard(Long idParam) {
//        Board board = null; // return할 타입 선언
//
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try{
//            // a. DB 연결 - Connection
//            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
//            conn = DBUtil.getInstance().getConnection();
////           conn = DBUtil.getConnection();
//
//            // b. SELECT SQL 준비 - Connection
//            String sql = "SELECT b.seq,b.user_id,u.name,b.title,b.content,b.pr_no,b.re_depth,b.re_ord,b.reg_date,b.hit,b.del_yn" +
//                   " FROM user u,board b WHERE u.id = b.user_id AND b.seq = ?";
//           ps = conn.prepareStatement(sql);
//            // c. 바인딩 - PreparedStatement
//           ps.setLong(1,idParam);
//
//            // d. SQL 실행 - PreparedStatement
//           rs = ps.executeQuery();
//
//            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
//            // f. e에서 읽어오지 못하는 경우도 있다.
//           if (rs.next()){
//               long seq = rs.getLong(1);
//               String userId = rs.getString(2);
//               String userName = rs.getString(3);
//               String title = rs.getString(4);
//               String content = rs.getString(5);
//               int prNo = rs.getInt(6);
//               int reDepth = rs.getInt(7);
//               int reOrd = rs.getInt(8);
//               Date regdate = rs.getDate(9);
//               int hit = rs.getInt(10);
//               String delYN = rs.getString(11);
//
//               board = new Board(seq,userId,userName,title,content,prNo,reDepth,reOrd,regdate,hit);
//           }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
//            DBUtil.close(rs,ps,conn);
//        }
//
//        return board;
//    }
//
//    @Override
//    public List<Board> getBoards(int start, int limit) {
//        List<Board> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try{
//            // a. DB 연결 - Connection
//            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
//            conn = DBUtil.getInstance().getConnection();
////            conn = DBUtil.getConnection();
//            if (conn != null){
//                System.out.println("conn ok!");
//                System.out.println(conn.getClass().getName());
//            }
//
//            // b. SELECT SQL 준비 - Connection
//            String sql = "SELECT b.seq,b.user_id,u.name,b.title,b.content,b.pr_no,b.re_depth,b.re_ord,b.reg_date,b.hit,b.del_yn " +
//                    "FROM user u, board b WHERE u.id = b.user_id ORDER BY b.seq DESC LIMIT ?,?";
//            ps = conn.prepareStatement(sql);
//
//            // c. 바인딩 - PreparedStatement
//            ps.setLong(1, start);
//            ps.setInt(2, limit);
//
//            // d. SQL 실행 - PreparedStatement
//            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete
//
//            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
//            // f. e에서 읽어오지 못하는 경우도 있다.
//            while (rs.next()){
//                long seq = rs.getLong(1);
//                String userId = rs.getString(2);
//                String userName = rs.getString(3);
//                String title = rs.getString(4);
//                String content = rs.getString(5);
//                int prNo = rs.getInt(6);
//                int reDepth = rs.getInt(7);
//                int reOrd = rs.getInt(8);
//                Date regdate = rs.getDate(9);
//                int hit = rs.getInt(10);
//                String delYN = rs.getString(11);
//
//                Board board = new Board(seq,userId,userName,title,prNo,reDepth,reOrd,regdate,hit);
//                list.add(board);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
//            DBUtil.close(rs,ps,conn);
//        }
//        return list;
//    }
//
////    @Override
//    public void setBoard(String id, String title, String content, int prNo, int depth, int ord) {
//        Board board = null;
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        try {
//            conn = DBUtil.getConnection();
//            String sql = "INSERT INTO board (user_id,title,content,pr_no,re_depth,re_ord) VALUES " +
//                    "(?,?,?,?,?,?)";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1,id);
//            ps.setString(2,title);
//            ps.setString(3,content);
//            ps.setInt(4,prNo);
//            ps.setInt(5,depth);
//            ps.setInt(6,ord);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            DBUtil.close(ps,conn);
//        }
//
//    }
//
//    @Override
//    public void addBoard(Board board) {
//
//    }
//
//    @Override
//    public Long getLastInsertId() {
//        return null;
//    }
//
//    @Override
//    public void updateLastInsertId(Long seq) {
//
//    }
//
//    @Override
//    public void updateHit(Long seq) {
//
//    }
//
//    @Override
//    public void deleteBoard(Long id) {
//
//    }
//
//    @Override
//    public void modifyBoard(Board board,Long id) {
//
//    }
//
//    @Override
//    public int listCnt() {
//        return 0;
//    }
//
//    @Override
//    public int getTotalCount() {
//        return 0;
//    }
//}
