package org.yassir.MajesticCup.model.entity;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;
}
