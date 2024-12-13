package org.yassir.MajesticCup.Dto.Match;


import org.yassir.MajesticCup.Dto.MatchResult.MatchResultDTO;

public record MatchRequestDTO(
        int round,
        String team1,
        String team2,
        MatchResultDTO result,
        String winner
) {}


