package org.yassir.MajesticCup.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Dto.Competition.CompetitionRequestDTO;
import org.yassir.MajesticCup.Mapper.ICompetitionMapper;
import org.yassir.MajesticCup.Model.Entity.*;
import org.yassir.MajesticCup.Model.Entity.Competition;
import org.yassir.MajesticCup.Repository.*;
import org.yassir.MajesticCup.Repository.CompetitionRepository;
import org.yassir.MajesticCup.Service.ICompetitionService;

import java.util.List;


@Service
public class CompetitionServiceImp implements ICompetitionService {


    private final CompetitionRepository competitionRepository;
    private final ICompetitionMapper competitionMapper;
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final RoundRepository roundRepository;


    @Autowired
    public CompetitionServiceImp(ICompetitionMapper competitionMapper, CompetitionRepository competitionRepository, MatchRepository matchRepository, TeamRepository teamRepository, RoundRepository roundRepository) {
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.roundRepository = roundRepository;
    }


    @Override
    public Competition createCompetition(CompetitionRequestDTO competitionRequestDTO) {
        Competition competition = competitionMapper.toEntity(competitionRequestDTO);

        List<String> teamsId = competitionRequestDTO.teams();
        List<Team> teams = teamsId.stream()
                .map(teamId -> teamRepository.findById(teamId)
                        .orElseThrow(() -> new RuntimeException("Team not found: " + teamId)))
                .toList();
        competition.setTeams(teams);

        List<String> roundsId = competitionRequestDTO.rounds();
        List<Round> rounds = roundsId.stream()
                .map(roundId -> roundRepository.findById(roundId)
                        .orElseThrow(() -> new RuntimeException("Round not found: " + roundId)))
                .toList();
        competition.setRounds(rounds);

        return competitionRepository.save(competition);

    }



    @Override
    public Competition getCompetitionById(String competitionId) {
        return competitionRepository.findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + competitionId));

    }

    @Override
    public Competition updateCompetition(String id, CompetitionRequestDTO competitionRequestDTO) {
        Competition existingCompetition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + id));

        return competitionRepository.save(existingCompetition);

    }

    @Override
    public List<Competition> getAllCompetitions() {
        return (List<Competition>) competitionRepository.findAll();

    }


    @Override
    public void deleteCompetition(String competitionId) {
        if (!competitionRepository.existsById(competitionId)) {
            throw new IllegalArgumentException("Competition not found with ID: " + competitionId);
        }
        competitionRepository.deleteById(competitionId);
    }



























}
