package dotori.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 프로젝트 메인 클래스
 * @SpringBootApplication : 스프링 부트의 자동 설정 기능 사용
 * 이 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야 함.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);   // 내장 WAS 실행
    }
}
