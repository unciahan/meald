package dotori.springboot.domain.posts;

import dotori.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
@Getter : [Lombok] generate getter method for all fields
@NoArgsConstructor : [Lombok] generate default constructor
@Entity : [JPA] link class to database table (PascalCase -> snake_case)
@Id : [JPA] primary key
@GeneratedValue : [JPA] primary key generation setting
strategy = GenerationType.IDENTITY : generate by auto-increment
@Column : [JPA] column
@Builder : [Lombok] create builder pattern class
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
