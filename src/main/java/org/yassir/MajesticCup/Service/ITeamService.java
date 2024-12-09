package org.yassir.MajesticCup.Service;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;

import java.util.List;

public interface ITeamService {
    TeamResponseDTO createTeam(TeamRequestDTO teamRequestDTO);

//    TeamResponseDTO getTeamById(Long teamId);
//
//    TeamResponseDTO updateTeam(Long id, TeamRequestDTO teamRequestDTO);
//
    List<TeamResponseDTO> getAllTeams();
//
//    void deleteTeam(Long teamId);




}
