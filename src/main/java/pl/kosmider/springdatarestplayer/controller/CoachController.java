package pl.kosmider.springdatarestplayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kosmider.springdatarestplayer.entity.Coach;
import pl.kosmider.springdatarestplayer.repository.CoachRepository;

import java.util.List;

@RestController
public class CoachController {

    private CoachRepository coachRepository;

    @Autowired
    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @GetMapping("/coaches")
    public List<Coach> coaches(){
        return coachRepository.findAll();
    }
}
