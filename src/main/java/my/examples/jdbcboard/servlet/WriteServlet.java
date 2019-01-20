package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
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

@WebServlet(name = "WriteServlet", urlPatterns = "/board/write")
public class WriteServlet extends HttpServlet {
    public WriteServlet() {
        System.out.println("WriteServlet()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        System.out.println(userId);
        System.out.println("=========================="+title);


        BoardService boardService = new BoardServiceImpl();
        Board board = new Board(title, content, userId);
        boardService.addBoard(board);
        resp.sendRedirect("/board/list");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//
//        String name = req.getParameter("name");
//        String password = req.getParameter("password");
//        String title = req.getParameter("title");
//        String content = req.getParameter("content");
//        System.out.println(name + password + title + content);
//
////        Board board = new Board(name, password, title, content);
////        req.setAttribute("board", board);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/board/list");
//        requestDispatcher.forward(req, resp);
//
//        String idStr = req.getParameter("id");
//        Long id = 0L;
//
//        try {
//            id = Long.parseLong(idStr);
//        } catch (Exception ignore) {
//            // 오류 화면으로 redirect
//            return;
//        }
//
//        BoardDao boardDao = new BoardDaoImpl();
////        boardDao.setBoard();
////        if (board == null) {
//            // 오류 화면으로 redirect
////            return;
////        }
//
////        req.setAttribute("board", board);
////        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/view.jsp");
////        requestDispatcher.forward(req, resp);
//    }



    @Override
    public void destroy() {
        System.out.println("----- destroy -----");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("----- init -----");
    }
}
