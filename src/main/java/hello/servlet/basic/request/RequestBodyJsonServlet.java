package hello.servlet.basic.request;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = "+messageBody); //(1) json 형태(문자 형태)그대로 출력
        /*json 형태를 자바 객체로 바꿀거임 -> json라이브러리가 필요*/
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);//메시지 바디, 클래스 타입을 넣어주면 JSON 타입이 객체 타입에 맞게 변환된다.

        System.out.println("helloData.username = "+helloData.getUsername());
        System.out.println("helloData.age = "+helloData.getAge());

        response.getWriter().write("OK");//응답 안심 출력
        //객체로 변환되어서 출력 되는 모습을 볼 수 있음
    }
}
