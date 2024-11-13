package com.anderson.gamelist.dto;


import com.anderson.gamelist.entities.GameList;

public record GameListDTO(
        Long id,
        String name
) {
    public GameListDTO (GameList entity) {
        this(
                entity.getId(),
                entity.getName()
        );
    }

}
