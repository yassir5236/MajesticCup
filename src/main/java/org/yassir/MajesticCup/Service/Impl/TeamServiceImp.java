package org.yassir.MajesticCup.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;
import org.yassir.MajesticCup.Mapper.ITeamMapper;
import org.yassir.MajesticCup.Model.Entity.Team;
import org.yassir.MajesticCup.Repository.TeamRepository;
import org.yassir.MajesticCup.Service.ITeamService;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class TeamServiceImp implements ITeamService {


    private final TeamRepository teamRepository;
    private final ITeamMapper teamMapper;


    @Autowired
    public TeamServiceImp(TeamRepository teamRepository, ITeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;

    }


    @Override
    public TeamResponseDTO createTeam(TeamRequestDTO teamRequestDTO) {
        Team team = teamMapper.toEntity(teamRequestDTO);
        System.out.println(teamRequestDTO);
        Team savedTeam = teamRepository.save(team);
        System.out.println(savedTeam);
        return teamMapper.toResponseDto(savedTeam);
    }

//
//    @Override
//    public TeamResponseDTO getTeamById(Long teamId) {
//        Team team = teamRepository.findById(teamId)
//                .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));
//        return teamMapper.toResponseDto(team);
//    }
//
//    @Override
//    public TeamResponseDTO updateTeam(Long id, TeamRequestDTO teamRequestDTO) {
//        Team existingTeam = teamRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + id));
//
//
//        double fieldSomeArea = existingTeam.getFields().stream().mapToDouble(Field::getArea).sum();
//
//        if (fieldSomeArea > teamRequestDTO.totalArea()){
//            throw new IllegalArgumentException("Total area of team doesn't match");
//        }
//
//        existingTeam.setName(teamRequestDTO.name());
//        existingTeam.setCreated(teamRequestDTO.created());
//        existingTeam.setLocation(teamRequestDTO.location());
//        existingTeam.setTotalArea(teamRequestDTO.totalArea());
//        Team updatedTeam = teamRepository.save(existingTeam);
//        return teamMapper.toResponseDto(updatedTeam);
//    }
//
    @Override
    public List<TeamResponseDTO> getAllTeams() {
        List<Team> teams = (List<Team>) teamRepository.findAll();
        return teams.stream()
                .map(teamMapper::toResponseDto)
                .collect(Collectors.toList());
    }
//
//
//    @Override
//    public void deleteTeam(Long teamId) {
//        if (!teamRepository.existsById(teamId)) {
//            throw new IllegalArgumentException("Team not found with ID: " + teamId);
//        }
//        teamRepository.deleteById(teamId);
//    }



























}
