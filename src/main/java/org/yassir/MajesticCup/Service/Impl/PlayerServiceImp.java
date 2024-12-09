package org.yassir.MajesticCup.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Dto.Player.PlayerRequestDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Mapper.IPlayerMapper;
import org.yassir.MajesticCup.Model.Entity.Player;
import org.yassir.MajesticCup.Model.Entity.Team;
import org.yassir.MajesticCup.Repository.PlayerRepository;
import org.yassir.MajesticCup.Repository.TeamRepository;
import org.yassir.MajesticCup.Service.IPlayerService;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlayerServiceImp implements IPlayerService {


    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final IPlayerMapper playerMapper;


    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository, IPlayerMapper playerMapper , TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.teamRepository = teamRepository;


    }


    @Override
    public PlayerResponseDTO createPlayer(PlayerRequestDTO playerRequestDTO) {
        Team team =teamRepository.findById(playerRequestDTO.teamId()).orElseThrow(()->new RuntimeException("team not found"));
        Player player = playerMapper.toEntity(playerRequestDTO);

//        List <Player> players = new ArrayList<>();
//        players.add(player);
//
//        team.setPlayers(players);
        player.setTeam(team);

        Player savedPlayer = playerRepository.save(player);

        return playerMapper.toResponseDto(savedPlayer);
    }

//
//    @Override
//    public PlayerResponseDTO getPlayerById(Long teamId) {
//        Player team = teamRepository.findById(teamId)
//                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + teamId));
//        return teamMapper.toResponseDto(team);
//    }
//
//    @Override
//    public PlayerResponseDTO updatePlayer(Long id, PlayerRequestDTO teamRequestDTO) {
//        Player existingPlayer = teamRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + id));
//
//
//        double fieldSomeArea = existingPlayer.getFields().stream().mapToDouble(Field::getArea).sum();
//
//        if (fieldSomeArea > teamRequestDTO.totalArea()){
//            throw new IllegalArgumentException("Total area of team doesn't match");
//        }
//
//        existingPlayer.setName(teamRequestDTO.name());
//        existingPlayer.setCreated(teamRequestDTO.created());
//        existingPlayer.setLocation(teamRequestDTO.location());
//        existingPlayer.setTotalArea(teamRequestDTO.totalArea());
//        Player updatedPlayer = teamRepository.save(existingPlayer);
//        return teamMapper.toResponseDto(updatedPlayer);
//    }
//
//    @Override
//    public List<PlayerResponseDTO> getAllPlayers() {
//        List<Player> teams = (List<Player>) teamRepository.findAll();
//        return teams.stream()
//                .map(teamMapper::toResponseDto)
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public void deletePlayer(Long teamId) {
//        if (!teamRepository.existsById(teamId)) {
//            throw new IllegalArgumentException("Player not found with ID: " + teamId);
//        }
//        teamRepository.deleteById(teamId);
//    }



























}
