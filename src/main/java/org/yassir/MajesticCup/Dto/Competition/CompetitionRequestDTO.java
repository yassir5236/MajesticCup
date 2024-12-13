package org.yassir.MajesticCup.Dto.Competition;

import org.yassir.MajesticCup.Model.Entity.Round;
import org.yassir.MajesticCup.Model.Entity.Team;

import java.util.ArrayList;
import java.util.List;

public record CompetitionRequestDTO(

        String name,
        int numberOfTeams,
        List<String> teams,
        int currentRound,
        List<String> rounds
) {
}

