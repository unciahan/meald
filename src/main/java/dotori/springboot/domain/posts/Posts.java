package dotori.springboot.domain.posts;

import dotori.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor   // 기본 생성자 자동 추가
@Entity   // 테이블과 링크될 클래스임을 명시 (PascalCase -> snake_case 로 매칭)
public class Posts  extends BaseTimeEntity {

    @Id   // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto_increment 설정
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)   // columnDefinition 의 기본값은 varchar(255)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
