package org.yassir.MajesticCup.Dto.Match;

import org.yassir.MajesticCup.Dto.MatchResult.MatchResultDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;

public record MatchResponseDTO(
        String id,
        int round,
        TeamResponseDTO team1,
        TeamResponseDTO team2,
        MatchResultDTO result,
        PlayerResponseDTO winner
) {}

