package org.yassir.MajesticCup.Dto.Player;

import org.yassir.MajesticCup.Dto.Team.EmbeddedTeamDTO;

public record PlayerResponseDTO(
        String id ,
        String name,
        String surname,
        String position,
        int number,
        EmbeddedTeamDTO team

) {
}
