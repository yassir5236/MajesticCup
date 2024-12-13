package org.yassir.MajesticCup.Service;

import org.yassir.MajesticCup.Dto.Player.PlayerRequestDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;

import java.util.List;

public interface IPlayerService {
    PlayerResponseDTO createPlayer(PlayerRequestDTO playerRequestDTO);

    PlayerResponseDTO getPlayerById(String playerId);

    PlayerResponseDTO updatePlayer(String id, PlayerRequestDTO playerRequestDTO);

    List<PlayerResponseDTO> getAllPlayers();

    void deletePlayer(String playerId);
}
