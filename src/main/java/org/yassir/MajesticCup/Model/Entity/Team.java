package org.yassir.MajesticCup.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String city;
    private List<Player> players = new ArrayList<>();

}
