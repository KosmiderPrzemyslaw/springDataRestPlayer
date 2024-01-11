package pl.kosmider.springdatarestplayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.springdatarestplayer.entity.Coach;
import pl.kosmider.springdatarestplayer.repository.CoachRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CoachController {

    private CoachRepository coachRepository;

    @Autowired
    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @GetMapping("/coaches")
    public List<Coach> coaches() {
        return coachRepository.findAll();
    }

    @GetMapping("/coach/{id}")
    public Coach findCoachById(@PathVariable Long id) {
        Optional<Coach> coachById = coachRepository.findById(id);
        Coach coach = null;

        if (coachById.isPresent()) {
            coach = coachById.get();
        } else {
            throw new RuntimeException("Can not find coach with id " + id);
        }
        return coach;
    }

    @PostMapping("/coach")
    public Coach saveCoach(@RequestBody Coach coach) {
        coach.setId(0L);
        return coachRepository.save(coach);
    }

    @PutMapping("/coach")
    public Coach updateCoach(@RequestBody Coach coach) {
        return coachRepository.save(coach);
    }

    @DeleteMapping("/coach/{coachId}")
    public Coach deleteCoach(@PathVariable Long coachId) {
        Optional<Coach> coach = coachRepository.findById(coachId);

        Coach coachFromDb = null;

        if (coach.isPresent()) {
            coachFromDb = coach.get();
            coachRepository.delete(coachFromDb);
        } else {
            throw new RuntimeException("Can not find coach with id -" + coachId);
        }
        return coachFromDb;
    }
}
