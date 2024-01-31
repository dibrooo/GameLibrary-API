package dev.antonio.gameLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GamesController {
    @Autowired
    private GamesService gamesService;
    @GetMapping
    public ResponseEntity<List<Games>> getAllGames() {
        return new ResponseEntity<List<Games>>(gamesService.allGames(), HttpStatus.OK);
    }
}
