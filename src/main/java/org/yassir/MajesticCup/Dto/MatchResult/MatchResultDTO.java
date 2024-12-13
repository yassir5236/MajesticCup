package org.yassir.MajesticCup.Dto.MatchResult;

import org.yassir.MajesticCup.Model.Entity.PlayerStatistics;

import java.util.List;

public record MatchResultDTO(
         int team1Goals,
         int team2Goals,
         List<PlayerStatistics> statistics
) {
}
