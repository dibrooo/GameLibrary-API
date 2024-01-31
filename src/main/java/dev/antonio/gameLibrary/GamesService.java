package dev.antonio.gameLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {
    @Autowired
    private GamesRepository gamesRepository;
    public List<Games> allGames() {
        return gamesRepository.findAll();
    }
}
