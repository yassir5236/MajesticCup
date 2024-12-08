package org.yassir.MajesticCup.Model.Entity;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchDetails {
    private String matchId;
    private String team1;
    private String team2;
    private Result result;
    private String winner;
}
