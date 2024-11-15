package com.anderson.gamelist.services;


import com.anderson.gamelist.dto.GameListDTO;
import com.anderson.gamelist.entities.GameList;
import com.anderson.gamelist.projections.GameMinProjection;
import com.anderson.gamelist.repositories.GameListRepository;
import com.anderson.gamelist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository repository;
    private final GameRepository gameRepository;

    public GameListService(GameListRepository repository, GameRepository gameRepository) {
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> getAllLists() {
        List<GameList> list = repository.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
