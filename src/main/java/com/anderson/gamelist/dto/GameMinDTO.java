package com.anderson.gamelist.dto;

import com.anderson.gamelist.entities.Game;
import com.anderson.gamelist.projections.GameMinProjection;

public record GameMinDTO(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription) {

    public GameMinDTO(Game entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getYear(),
                entity.getImgUrl(),
                entity.getShortDescription()
        );
    }

    public GameMinDTO(GameMinProjection projection) {
        this(
                projection.getId(),
                projection.getTitle(),
                projection.getYear(),
                projection.getImgUrl(),
                projection.getShortDescription()
        );
    }
}
