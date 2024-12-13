package org.yassir.MajesticCup.Model.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yassir.MajesticCup.Repository.MatchRepository;

import java.util.List;

@Component
public class MatchMapperHelper {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> fromIds(List<String> matchIds) {
        return matchIds.stream()
                .map(id -> matchRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Match not found: " + id)))
                .toList();
    }

    public List<String> toIds(List<Match> matches) {
        return matches.stream()
                .map(Match::getId)
                .toList();
    }
}
