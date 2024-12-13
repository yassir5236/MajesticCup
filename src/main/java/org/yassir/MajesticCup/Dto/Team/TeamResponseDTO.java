package org.yassir.MajesticCup.Dto.Team;

import org.yassir.MajesticCup.Dto.Player.EmbeddedPlayerDTO;

import java.util.List;

public record TeamResponseDTO(
        String id,
        String name,
        String city,
        List<EmbeddedPlayerDTO> players

) {

}


