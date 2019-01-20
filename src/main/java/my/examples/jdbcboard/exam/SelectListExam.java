package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.dao.BoardDao;
//import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dao.BoardDaoImplHikari;

import java.util.List;

public class SelectListExam {
    public static void main(String args[]){
        BoardDao boardDao = new BoardDaoImplHikari();
        List<Board> boards = boardDao.getBoards(0,3);
        for (Board board : boards){
            System.out.println(board);
        }
    }
}
