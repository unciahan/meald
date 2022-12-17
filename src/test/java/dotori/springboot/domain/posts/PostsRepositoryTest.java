package dotori.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest   // 사용시 H2 DB 자동 사용
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After   // 단위 테스트가 끝날 때마다 수행되는 메소드
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
}
