package dotori.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)   // JUnit 내장 실행자 외 다른 실행자로 실행 (SpringRunner)
@WebMvcTest(controllers = HelloController.class)    // Web 테스트용 annotation
public class HelloControllerTest {

    @Autowired   // Spring 이 관리하는 bean 주입
    private MockMvc mvc;   // MockMvc : Spring MVC 테스트의 시작점

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))           // "/hello" 로 GET 요청
                .andExpect(status().isOk())            // status  : 200 검증
                .andExpect(content().string(hello));   // content : hello 검증
    }

}
