package org.yassir.MajesticCup.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private List<String> teams;
    private int currentRound;
    private List<String> rounds;
}
