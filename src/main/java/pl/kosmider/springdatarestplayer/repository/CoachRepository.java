package pl.kosmider.springdatarestplayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosmider.springdatarestplayer.entity.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
