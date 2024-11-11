package com.anderson.gamelist.dto;

public record GameMinDTO(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription) {
}
