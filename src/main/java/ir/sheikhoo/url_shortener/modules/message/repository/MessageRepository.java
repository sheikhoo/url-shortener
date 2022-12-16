package ir.sheikhoo.url_shortener.modules.message.repository;

import ir.sheikhoo.url_shortener.modules.message.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Messages,Integer> {
}
