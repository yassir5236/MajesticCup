package org.yassir.MajesticCup.Service;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;

import java.util.List;

public interface ITeamService {
    TeamResponseDTO createTeam(TeamRequestDTO teamRequestDTO);

    TeamResponseDTO getTeamById(String teamId);
    TeamResponseDTO updateTeam(String id, TeamRequestDTO teamRequestDTO);
    List<TeamResponseDTO> getAllTeams();

    void deleteTeam(String teamId);




}
