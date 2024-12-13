package org.yassir.MajesticCup.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Dto.Round.RoundRequestDTO;
import org.yassir.MajesticCup.Model.Entity.Round;
import org.yassir.MajesticCup.Mapper.IRoundMapper;
import org.yassir.MajesticCup.Model.Entity.Competition;
import org.yassir.MajesticCup.Model.Entity.Match;
import org.yassir.MajesticCup.Model.Entity.Round;
import org.yassir.MajesticCup.Repository.CompetitionRepository;
import org.yassir.MajesticCup.Repository.MatchRepository;
import org.yassir.MajesticCup.Repository.RoundRepository;
import org.yassir.MajesticCup.Service.IRoundService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoundServiceImp implements IRoundService {


    private final RoundRepository roundRepository;
    private final IRoundMapper roundMapper;
    private final CompetitionRepository competitionRepository;
    private final MatchRepository matchRepository;


    @Autowired
    public RoundServiceImp(RoundRepository roundRepository, IRoundMapper roundMapper, CompetitionRepository competitionRepository, MatchRepository matchRepository) {
        this.roundRepository = roundRepository;
        this.roundMapper = roundMapper;
        this.competitionRepository = competitionRepository;
        this.matchRepository = matchRepository;
    }


    @Override
    public Round createRound(RoundRequestDTO roundRequestDTO) {
        Round round = roundMapper.toEntity(roundRequestDTO);

        Competition competition = competitionRepository.findById(roundRequestDTO.competition())
                .orElseThrow(()-> new RuntimeException("Competition not found"));

        round.setCompetition(competition);

        List<String> matchIds = roundRequestDTO.matches();
        List<Match> matches = matchIds.stream()
                .map(matchId -> matchRepository.findById(matchId)
                        .orElseThrow(() -> new RuntimeException("Match not found: " + matchId)))
                .toList();
        round.setMatches(matches);

        return roundRepository.save(round);

    }



    @Override
    public Round getRoundById(String roundId) {
        Round round = roundRepository.findById(roundId)
                .orElseThrow(() -> new IllegalArgumentException("Round not found with ID: " + roundId));
        return round;
    }

    @Override
    public Round updateRound(String id, RoundRequestDTO roundRequestDTO) {
        Round existingRound = roundRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Round not found with ID: " + id));

        return roundRepository.save(existingRound);
    }

    @Override
    public List<Round> getAllRounds() {
        return  (List<Round>) roundRepository.findAll();

    }


    @Override
    public void deleteRound(String roundId) {
        if (!roundRepository.existsById(roundId)) {
            throw new IllegalArgumentException("Round not found with ID: " + roundId);
        }
        roundRepository.deleteById(roundId);
    }



























}
