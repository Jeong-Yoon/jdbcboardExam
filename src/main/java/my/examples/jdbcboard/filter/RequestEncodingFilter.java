package my.examples.jdbcboard.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "RequestEncodingFilter",urlPatterns = {"/*"}) // /*로 설정해서 모든 실행 시 필터를 거침.
public class RequestEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RequestEncodingFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        System.out.println("RequestEncodingFilter doFilter start");
        // 다음 필터 실행
        filterChain.doFilter(servletRequest, servletResponse);
        // 서블릿 응답 후
        System.out.println("RequestEncodingFilter doFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("RequestEncodingFilter destroy");
    }
}
