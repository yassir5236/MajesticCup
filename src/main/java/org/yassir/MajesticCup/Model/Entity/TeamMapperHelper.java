package org.yassir.MajesticCup.Model.Entity;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.yassir.MajesticCup.Repository.TeamRepository;

@Component
public class TeamMapperHelper {
    private final TeamRepository teamRepository;

    public TeamMapperHelper(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Named("stringToTeam")
    public Team map(String teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found: " + teamId));
    }
}
