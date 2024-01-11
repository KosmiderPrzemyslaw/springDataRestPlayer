package pl.kosmider.springdatarestplayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.springdatarestplayer.entity.Player;
import pl.kosmider.springdatarestplayer.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
public class PlayerController {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public List<Player> players() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Player getSinglePlayer(@PathVariable Long id) {
        Optional<Player> playerById = playerRepository.findById(id);

        Player player = null;

        if (playerById.isPresent()) {
            player = playerById.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return player;
    }

    @GetMapping("/addPlayer")
    public String addPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);

        return "player-form";
    }

    @PostMapping("/processPlayerForm")
    @ResponseBody
    public String addPlayer(@ModelAttribute("player") Player player) {
        player.setId(0);
        playerRepository.save(player);
        return player.toString();
    }

    @PostMapping("/player")
    public Player savePlayer(@RequestBody Player player) {
        player.setId(0);
        return playerRepository.save(player);
    }

    @PutMapping("/player")
    public Player updatePlayer(@RequestBody Player player) {
        Player dbPlayer = playerRepository.save(player);
        return dbPlayer;
    }

    @DeleteMapping("/player/{id}")
    public Player deletePlayer(@PathVariable Long id) {
        Optional<Player> player = playerRepository.findById(id);

        Player playerInDb = null;

        if (player.isPresent()) {
            playerInDb = player.get();
            playerRepository.delete(playerInDb);
        } else {
            throw new RuntimeException("Did not find player id+ " + id);
        }
        return playerInDb;
    }


}
