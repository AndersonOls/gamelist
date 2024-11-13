package com.anderson.gamelist.services;


import com.anderson.gamelist.dto.GameListDTO;
import com.anderson.gamelist.entities.GameList;
import com.anderson.gamelist.repositories.GameListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository repository;

    public GameListService(GameListRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> getAllLists() {
        List<GameList> list = repository.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }
}
