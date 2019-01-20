package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;

import java.util.List;

// Dao : Data Access Object
public interface BoardDao {
    Board getBoard(Long id);
    List<Board> getBoards(int start, int limit);
    void addBoard(Board board);
    Long getLastInsertId();
    void updateLastInsertId(Long id);
    void updateHit(Long id);
    void deleteBoard(Long id);
    void modifyBoard(Board board,Long id);
    int listCnt();
    int getTotalCount();
//    public void setBoard(String id, String title, String content, int prNo, int depth, int ord);
}
