package com.anderson.gamelist.services;

import com.anderson.gamelist.dto.GameMinDTO;
import com.anderson.gamelist.entities.Game;
import com.anderson.gamelist.exceptions.GameNotFoundException;
import com.anderson.gamelist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<GameMinDTO> findAll() {
        List<Game> games = repository.findAll();
        if (games.isEmpty()) {
            throw new GameNotFoundException("There are no games in the database");
        }
        return games.stream()
                .map(game -> new GameMinDTO(
                        game.getId(),
                        game.getTitle(),
                        game.getYear(),
                        game.getImgUrl(),
                        game.getShortDescription()))
                .collect(Collectors.toList());
    }
}
