package pl.sdaproject.quiz.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdaproject.quiz.database.entities.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
