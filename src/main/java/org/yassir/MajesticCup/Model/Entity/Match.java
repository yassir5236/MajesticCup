package org.yassir.MajesticCup.Model.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "matches")
public class Match {
    @Id
    private String id;
    private int round;
    private String team1;
    private String team2;
    private Result result;
    private String winner;
}

