package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImplHikari;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyServlet",urlPatterns = "/board/modify")
public class ModifyServlet extends HttpServlet {
    public ModifyServlet() {
        System.out.println("ModifyServlet()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = 0L;

        try {
            id = Long.parseLong(idStr);
        }catch (Exception ignore){
            // 오류 화면으로 redirect
            return;
        }

        BoardService boardService = new BoardServiceImpl();
        Board board = boardService.getBoard(id);

        req.setAttribute("board",board);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = Long.parseLong(idStr);
        String userId = req.getParameter("userId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Board board = new Board(title,content,userId);

        BoardService boardService = new BoardServiceImpl();
        boardService.modifyBoard(board, id);

        resp.sendRedirect("/board/view?id="+id);
    }

    @Override
    public void destroy() {
        System.out.println("----- destroy -----");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("----- init -----");
    }

}
