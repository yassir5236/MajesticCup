package org.yassir.MajesticCup.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String city;
    private List<Player> players = new ArrayList<>();
}

