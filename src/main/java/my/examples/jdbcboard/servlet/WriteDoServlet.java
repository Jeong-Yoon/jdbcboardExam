package my.examples.jdbcboard.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WriteDoServlet", urlPatterns = "/board/write.do")
public class WriteDoServlet extends HttpServlet {
    public WriteDoServlet(){
        System.out.println("WriteDoServlet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req,resp);
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
