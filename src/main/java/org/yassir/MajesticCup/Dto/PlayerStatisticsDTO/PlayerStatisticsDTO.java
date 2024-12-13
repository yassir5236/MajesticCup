package org.yassir.MajesticCup.Dto.PlayerStatisticsDTO;

public record PlayerStatisticsDTO(
        String playerId,
        int goals,
        int assists,
        int yellowCards,
        int redCards
) {}