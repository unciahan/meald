package dotori.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
@EnableJpaAuditing : Enable auditing in JPA
@SpringBootApplication : main class, springboot will start from here if executed.
SpringApplication.run : start embedded tomcat
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);   // 내장 WAS 실행
    }
}
