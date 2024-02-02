package dev.antonio.gameLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/games")
public class GamesController {
    @Autowired
    private GamesService gamesService;
    @GetMapping
    public ResponseEntity<List<Games>> getAllGames() {
        return new ResponseEntity<>(gamesService.allGames(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Games> createGame(@RequestBody GamesDTO gamesDTO) {
        return new ResponseEntity<>(gamesService.createGame(gamesDTO), HttpStatus.CREATED);
    }
}
