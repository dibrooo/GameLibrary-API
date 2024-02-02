package dev.antonio.gameLibrary.service;

import dev.antonio.gameLibrary.dto.GamesDTO;
import dev.antonio.gameLibrary.entity.Games;
import dev.antonio.gameLibrary.repository.GamesRepository;
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
    public Games createGame(GamesDTO gamesDTO) {
        Games newGame = new Games();

        newGame.setName(gamesDTO.getName());
        newGame.setDescription(gamesDTO.getDescription());
        newGame.setCategories(gamesDTO.getCategories());
        newGame.setPrice(gamesDTO.getPrice());
        newGame.setRating(gamesDTO.getRating());
        newGame.setRelease_date(gamesDTO.getRelease_date());
        newGame.setDeveloper(gamesDTO.getDeveloper());
        newGame.setPublisher(gamesDTO.getPublisher());
        newGame.setCover_image(gamesDTO.getCover_image());

        return gamesRepository.save(newGame);
    }
}
