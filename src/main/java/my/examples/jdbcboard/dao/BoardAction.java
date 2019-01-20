package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.dto.Paging;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class BoardAction {

    public void execute(HttpServletRequest request, HttpServletResponse response) {

        BoardService boardService = new BoardServiceImpl();
        List<Board> boards = new ArrayList<>();
//        ArrayList list<boarddto>;
        int totalCount = boardService.getTotalCount();
        System.out.println(totalCount+"=================");
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

        Paging paging = new Paging();

        paging.setPageNo(page); //get방식의 parameter값으로 반은 page변수, 현재 페이지 번호
        paging.setPageSize(10); // 한페이지에 불러낼 게시물의 개수 지정
        paging.setTotalCount(totalCount);

        page = (page - 1) * 10; //select해오는 기준을 구한다.

        boards = boardService.getBoards(page,paging.getPageSize());

        request.setAttribute("boards",boards);
        request.setAttribute("paging", paging);
    }
}
