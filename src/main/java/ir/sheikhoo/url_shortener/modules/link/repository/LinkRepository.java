package ir.sheikhoo.url_shortener.modules.link.repository;

import ir.sheikhoo.url_shortener.modules.link.model.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Links,Integer> {

    @Query(value = "select IFNULL(SUM(click),0) from links", nativeQuery = true)
    Long numberClick();

    @Query(value = "select u from Links u where u.short_url=?1")
    Links getLink(String short_url);

    @Query(nativeQuery = true,value = "select * from links u order by u.id desc limit :limit")
    List<Links> getLatestLinks(@Param("limit") int limit);

    @Query(nativeQuery = true,value = "select * from links u order by u.click desc limit :limit")
    List<Links> getPopularLinks(@Param("limit") int limit);

    @Query(nativeQuery = true,value = "select * from links l join users u on l.user_id=u.id" +
            " where u.username=:email")
    List<Links> findUserLink(@Param("email") String email);
}
