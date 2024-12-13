package org.yassir.MajesticCup.Model.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import javax.xml.transform.Result;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "matches")
public class Match {
    @Id
    private String id;
    private int round;
    private Team team1;
    private Team team2;
    private MatchResult result;
    private Player winner;


}


