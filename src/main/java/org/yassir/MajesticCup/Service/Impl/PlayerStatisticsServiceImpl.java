package org.yassir.MajesticCup.Service.Impl;


import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Dto.PlayerStatisticsDTO.PlayerStatisticsDTO;
import org.yassir.MajesticCup.Model.Entity.Match;
import org.yassir.MajesticCup.Model.Entity.PlayerStatistics;
import org.yassir.MajesticCup.Repository.MatchRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerStatisticsServiceImpl {

    private final MatchRepository matchRepository;

    public PlayerStatisticsServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<PlayerStatisticsDTO> getTopScorers() {
        Map<String, PlayerStatistics> aggregatedStats = aggregateStatistics();

        return aggregatedStats.values().stream()
                .sorted(Comparator.comparingInt(PlayerStatistics::getGoals).reversed())
                .map(stat -> new PlayerStatisticsDTO(
                        stat.getPlayerId(),
                        stat.getGoals(),
                        stat.getAssists(),
                        stat.getYellowCards(),
                        stat.getRedCards()
                ))
                .collect(Collectors.toList());
    }

    public List<PlayerStatisticsDTO> getTopAssists() {
        Map<String, PlayerStatistics> aggregatedStats = aggregateStatistics();

        return aggregatedStats.values().stream()
                .sorted(Comparator.comparingInt(PlayerStatistics::getAssists).reversed())
                .map(stat -> new PlayerStatisticsDTO(
                        stat.getPlayerId(),
                        stat.getGoals(),
                        stat.getAssists(),
                        stat.getYellowCards(),
                        stat.getRedCards()
                ))
                .collect(Collectors.toList());
    }

    // Récupérer les joueurs avec le plus de cartons
//    public List<PlayerStatisticsDTO> getTopCards() {
//        Map<String, PlayerStatistics> aggregatedStats = aggregateStatistics();
//
//        return aggregatedStats.values().stream()
//                .sorted(Comparator.comparingInt(stat -> stat.getYellowCards() + stat.getRedCards()).reversed())
//                .map(stat -> new PlayerStatisticsDTO(
//                        stat.getPlayerId(),
//                        stat.getGoals(),
//                        stat.getAssists(),
//                        stat.getYellowCards(),
//                        stat.getRedCards()
//                ))
//                .collect(Collectors.toList());
//    }


    private Map<String, PlayerStatistics> aggregateStatistics() {
        List<Match> matches = matchRepository.findAll();
        Map<String, PlayerStatistics> aggregatedStats = new HashMap<>();

        for (Match match : matches) {
            if (match.getResult() != null && match.getResult().getStatistics() != null) {
                for (PlayerStatistics stat : match.getResult().getStatistics()) {
                    aggregatedStats.merge(stat.getPlayerId(), stat, (existing, newStat) -> {
                        existing.setGoals(existing.getGoals() + newStat.getGoals());
                        existing.setAssists(existing.getAssists() + newStat.getAssists());
                        existing.setYellowCards(existing.getYellowCards() + newStat.getYellowCards());
                        existing.setRedCards(existing.getRedCards() + newStat.getRedCards());
                        return existing;
                    });
                }
            }
        }

        return aggregatedStats;
    }


}
