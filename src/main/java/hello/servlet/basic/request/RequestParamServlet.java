package hello.servlet.basic.request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/**
 *
 * http://localhost:8080/request-param?username=hello&age=20  //username이 param 이름 이고 hello가 param의 값이다.
 * */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    //요청 , 응답 메세지는 서블릿이 모두 처리하고 나는 "응답, 요청" 쿼리만 써서 비즈니스 로직을 구성하면 된다!
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "="+ request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");//파라미터 값을 가져옴//hello
        String age = request.getParameter("age");
        System.out.println("이름은 "+username+" 이고, 나이는 "+age+"입니다!");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username = "+name);
        }
    }
}
