package pl.kosmider.springdatarestplayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosmider.springdatarestplayer.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
