package org.yassir.MajesticCup.Dto.Team;

import org.yassir.MajesticCup.Model.Entity.Player;

import java.util.List;

public record EmbeddedTeamDTO(
        String name,
        String city

) {
}
