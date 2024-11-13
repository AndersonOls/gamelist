package com.anderson.gamelist.controllers;

import com.anderson.gamelist.dto.GameListDTO;
import com.anderson.gamelist.dto.GameMinDTO;
import com.anderson.gamelist.services.GameListService;
import com.anderson.gamelist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    private final GameListService service;
    private final GameService gameService;

    public GameListController(GameListService service, GameService gameService) {
        this.service = service;
        this.gameService = gameService;
    }


    @GetMapping
    public ResponseEntity<List<GameListDTO>> getAllLists() {
        List<GameListDTO> games = service.getAllLists();
        return ResponseEntity.ok(games);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> getAllGamesByList(@PathVariable Long listId) {
        List<GameMinDTO> games = gameService.getAllGamesByList(listId);
        return ResponseEntity.ok(games);
    }

}
