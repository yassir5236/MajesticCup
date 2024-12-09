package org.yassir.MajesticCup.Dto.Team;

import org.yassir.MajesticCup.Model.Entity.Player;

import java.util.List;

public record TeamRequestDTO(
        String name,
        String city
//        List<Player> players
) {
}
