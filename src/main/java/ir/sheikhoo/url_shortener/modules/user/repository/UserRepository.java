package ir.sheikhoo.url_shortener.modules.user.repository;

import ir.sheikhoo.url_shortener.modules.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query("select u from Users u where u.username=:email")
    Users findUser(@Param("email") String email);
}
