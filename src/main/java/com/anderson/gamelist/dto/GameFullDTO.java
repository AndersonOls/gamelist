package com.anderson.gamelist.dto;

import com.anderson.gamelist.entities.Game;
import org.springframework.beans.BeanUtils;

public record GameFullDTO(
        Long id,
        String title,
        Integer year,
        String genre,
        String platforms,
        Double score,
        String imgUrl,
        String shortDescription,
        String longDescription
) {
    public static GameFullDTO fromEntity(Game game) {
        return new GameFullDTO(
                game.getId(),
                game.getTitle(),
                game.getYear(),
                game.getGenre(),
                game.getPlatforms(),
                game.getScore(),
                game.getImgUrl(),
                game.getShortDescription(),
                game.getLongDescription()
        );
    }
}
