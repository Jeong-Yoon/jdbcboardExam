package my.examples.jdbcboard.dao;

public class BoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT b.id,b.user_id,u.name,b.title,b.content,b.group_no,b.re_depth,b.re_ord,b.reg_date,b.read_cnt" +
                    " FROM user u,board b WHERE u.id = b.user_id AND b.id = ?";
    public static final String SELECT_BY_PAGING =
            "SELECT b.id,b.user_id,u.name,b.title,b.group_no,b.re_depth,b.re_ord,b.reg_date,b.read_cnt " +
                    "FROM user u, board b WHERE u.id = b.user_id ORDER BY group_no desc, re_ord LIMIT ?,?";
    public static final String INSERT =
            "INSERT INTO board(user_id,title,content) VALUES (?,?,?)";
    public static final String GET_LAST_INSERT_ID=
            "SELECT LAST_INSERT_ID()";
    public static final String UPDATE_LAST_INSERT_ID =
            "UPDATE board SET group_no = ? WHERE id = ?";
    public static final String UPDATE =
            "UPDATE board SET read_cnt = read_cnt+1 WHERE id = ?";
    public static final String DELETE =
            "DELETE FROM board WHERE id = ?";
    public static final String MODIFY=
            "UPDATE board SET title=?,content=? WHERE id = ?";
    public static final String GET_TOTAL_CNT=
            "SELECT count(id) FROM board";
    public static final String UPDATE_GROUP_SEQ_GT =
            "update board set re_ord = re_ord + 1 where group_no = ? and re_ord > ?";
    public static final String INSERT_RE =
            "insert into board (title, user_id, content, group_no, re_ord, re_depth) " +
                    "values( ?, ?, ?, ? ,  ? , ? )";
}

