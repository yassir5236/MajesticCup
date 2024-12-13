package org.yassir.MajesticCup.Service;

import org.yassir.MajesticCup.Dto.Competition.CompetitionRequestDTO;
import org.yassir.MajesticCup.Model.Entity.Competition;

import java.util.List;

public interface ICompetitionService {

    Competition createCompetition(CompetitionRequestDTO competitionRequestDTO);

    Competition getCompetitionById(String competitionId);
    Competition updateCompetition(String id, CompetitionRequestDTO competitionRequestDTO);
    List<Competition> getAllCompetitions();

    void deleteCompetition(String competitionId);
}
