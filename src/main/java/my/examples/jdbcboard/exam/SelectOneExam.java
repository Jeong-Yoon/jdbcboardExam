package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.dao.BoardDao;
//import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dao.BoardDaoImplHikari;

public class SelectOneExam {
    public static void main(String args[]) {
//        long idParam = 4L;
//
//        long start = 0L;
//        int limit = 6;
//
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            DBUtil.getConnection();
            BoardDao boardDao = new BoardDaoImplHikari();
            Board board = boardDao.getBoard(5L);
            System.out.println(board);
            // b. SELECT SQL 준비 - Connection
//            String sql = "select seq,user_id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn " +
//                    "from board where seq = ?"; // 한건

//            // c. 바인딩 - PreparedStatement
//            ps.setLong(1, idParam); // 첫번째 물음표에 5를 바인딩한다. //한건
//            ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
//            ps.setInt(2, limit);
            // d. SQL 실행 - PreparedStatement
//            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete
//            while (rs.next()) {
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
//                System.out.println(seq + "," + userId + ", " + userName + ", " + title + ", " + content + ", " + prNo
//                        + ", " + reDepth + ", " + reOrd + ", " + regdate + ", " + hit + ", " + delYN);
//            }
//}
//            if(rs.next()){
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
//                System.out.println(seq + "," + userId + ", " + userName + ", " + title + ", " + content + ", " + prNo
//                + ", "+reDepth+", "+reOrd+", "+regdate+", "+hit+", "+delYN);
//            }else{
//                System.out.println(idParam + "에 해당하는 값이 없습니다.");
//            }

//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
//            DBUtil.close(rs, ps, conn);
//        }
    }
}
