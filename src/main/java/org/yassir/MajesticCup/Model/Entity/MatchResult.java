package org.yassir.MajesticCup.Model.Entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchResult {
    private int team1Goals;
    private int team2Goals;
    private List<PlayerStatistics> statistics;
}

