package org.yassir.MajesticCup.Dto.Team;

import org.yassir.MajesticCup.Model.Entity.Player;

import java.util.List;

public record TeamResponseDTO(
        String id,
        String name,
        String city,
        List<Player> players
) {

}


