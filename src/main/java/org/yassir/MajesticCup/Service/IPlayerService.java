package org.yassir.MajesticCup.Service;

import org.yassir.MajesticCup.Dto.Player.PlayerRequestDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;

import java.util.List;

public interface IPlayerService {
    PlayerResponseDTO createPlayer(PlayerRequestDTO playerRequestDTO);

//    PlayerResponseDTO getPlayerById(Long teamId);
//
//    PlayerResponseDTO updatePlayer(Long id, PlayerRequestDTO teamRequestDTO);
//
//    List<PlayerResponseDTO> getAllPlayers();
//
//    void deletePlayer(Long teamId);
}
