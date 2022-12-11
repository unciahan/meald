package dotori.springboot.web;

import dotori.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController   // json 반환 컨트롤러로 설정
public class HelloController {

    @GetMapping("/hello")   // GET method 수신 API
    public String hello() {

        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            @RequestParam("name") String name,
            @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
