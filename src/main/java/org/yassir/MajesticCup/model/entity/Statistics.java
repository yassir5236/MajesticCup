package org.yassir.MajesticCup.model.entity;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Statistics {
    private String playerId;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
}

