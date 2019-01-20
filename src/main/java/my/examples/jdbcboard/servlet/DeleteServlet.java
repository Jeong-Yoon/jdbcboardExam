package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImplHikari;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/board/delete")
public class DeleteServlet extends HttpServlet {
    public DeleteServlet() {
        System.out.println("DeleteServlet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = 0L;

        try {
            String idStr = req.getParameter("id");
            id = Long.parseLong(idStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        BoardService boardService = new BoardServiceImpl();
        boardService.deleteBoard(id);

        resp.sendRedirect("/board/list");
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
