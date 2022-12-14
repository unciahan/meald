package dotori.springboot.domain.posts;

import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
@Runwith : use custom runner, not default junit runner
@SpringBootTest : use h2 as database
@Autowired : inject object dependency
@Test : run test case
@After : run method after executing @Test
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_and_find() {
        //given
        String title = "Test";
        String content = "Lorem ipsum";

        postsRepository.save(Posts.builder()   // id 존재시 update, 없으면 insert 쿼리 실행
                .title(title)
                .content(content)
                .author("unciahan@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();   // 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void register_BaseTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.of(2022,12,17,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createdDate = " + posts.getCreatedDate()
                + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
