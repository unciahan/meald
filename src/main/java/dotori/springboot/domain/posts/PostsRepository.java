package dotori.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Repository [JPA] == DAO [MyBatis]

JpaRepository : generate default CRUD methods
    - Create(Insert) : save(value) -- when value doesn't exist in table
    - Read(Select)   : findAll(), findById()
    - Update(Update) : save(value) -- when value exists in table
    - Delete(Delete) : deleteAll(), deleteById()

@Query : map query result to method
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
