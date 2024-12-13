package org.yassir.MajesticCup.Model.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yassir.MajesticCup.Repository.CompetitionRepository;
import org.yassir.MajesticCup.Repository.RoundRepository;
import org.yassir.MajesticCup.Repository.TeamRepository;

import java.util.List;

@Component
public class CompetitionMapperHelper {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private RoundRepository roundRepository;

    public List<Team> mapTeams(List<String> teamIds) {
        return teamIds.stream()
                .map(teamId -> teamRepository.findById(teamId)
                        .orElseThrow(() -> new RuntimeException("Team not found: " + teamId)))
                .toList();
    }

    public List<Round> mapRounds(List<String> roundIds) {
        return roundIds.stream()
                .map(roundId -> roundRepository.findById(roundId)
                        .orElseThrow(() -> new RuntimeException("Round not found: " + roundId)))
                .toList();
    }
}
