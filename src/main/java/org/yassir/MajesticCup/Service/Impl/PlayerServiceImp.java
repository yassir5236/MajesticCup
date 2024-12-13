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
import java.util.stream.Collectors;


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

        teamRepository.save(team);
        Player savedPlayer = playerRepository.save(player);

        return playerMapper.toResponseDto(savedPlayer);
    }


    @Override
    public PlayerResponseDTO getPlayerById(String playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + playerId));
        return playerMapper.toResponseDto(player);
    }

    @Override
    public PlayerResponseDTO updatePlayer(String id, PlayerRequestDTO playerRequestDTO) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + id));

        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("team not found with ID: " + id));


        existingPlayer.setName(playerRequestDTO.name());
        existingPlayer.setSurname(playerRequestDTO.surname());
        existingPlayer.setNumber(playerRequestDTO.number());
        existingPlayer.setPosition(playerRequestDTO.position());

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return playerMapper.toResponseDto(updatedPlayer);
    }

    @Override
    public List<PlayerResponseDTO> getAllPlayers() {
        List<Player> players = (List<Player>) playerRepository.findAll();
        return players.stream()
                .map(playerMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deletePlayer(String playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new IllegalArgumentException("Player not found with ID: " + playerId);
        }
        playerRepository.deleteById(playerId);
    }



























}
