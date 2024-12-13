package org.yassir.MajesticCup.Model.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "competitions")
public class Competition {
    @Id
    private String id;
    private String name;
    private int numberOfTeams;
    private List<Team> teams = new ArrayList<>();
    private int currentRound;
    private List<Round> rounds;
}



