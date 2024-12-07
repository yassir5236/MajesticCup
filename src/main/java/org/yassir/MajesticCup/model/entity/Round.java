package org.yassir.MajesticCup.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "rounds")
public class Round {
    @Id
    private String id;
    private int roundNumber;
    private String competitionId;
    private List<MatchDetails> matches;
}

