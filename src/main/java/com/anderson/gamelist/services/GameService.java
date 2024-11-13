package com.anderson.gamelist.services;

import com.anderson.gamelist.dto.GameFullDTO;
import com.anderson.gamelist.dto.GameMinDTO;
import com.anderson.gamelist.entities.Game;
import com.anderson.gamelist.exceptions.GameNotFoundException;
import com.anderson.gamelist.projections.GameMinProjection;
import com.anderson.gamelist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public GameFullDTO getFullGameDetails(Long id) {
        Optional<Game> gameOptional = repository.findById(id);
        Game game = gameOptional.orElseThrow(() -> new GameNotFoundException("Game not found with id: " + id));
        return GameFullDTO.fromEntity(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllGames() {
        List<Game> games = repository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllGamesByList(Long listId) {
        List<GameMinProjection> games = repository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }


}
