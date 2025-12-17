package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //localhost:8080/hello 는 여기서 이미 생성
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");//콘솔 로그 확인
        System.out.println("request = " + request);//was서버들이 request 객체를 구현하는 것
        System.out.println("response = " + response);

        String username = request.getParameter("username");//url의 파라미터 값 가져옴
        System.out.println("username = "+username);

        response.setContentType("text/plain"); //응답 메세지 일부 출력
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello"+username);
    }
}
