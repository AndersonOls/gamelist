package com.anderson.gamelist.controllers;

import com.anderson.gamelist.dto.GameFullDTO;
import com.anderson.gamelist.dto.GameMinDTO;
import com.anderson.gamelist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameFullDTO> getGameDetails(@PathVariable Long id) {
        GameFullDTO game = service.getFullGameDetails(id);
        return ResponseEntity.ok(game);
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAllGames() {
        List<GameMinDTO> games = service.findAllGames();
        return ResponseEntity.ok(games);
    }
}
