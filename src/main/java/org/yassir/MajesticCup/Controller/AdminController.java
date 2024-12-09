package org.yassir.MajesticCup.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;
import org.yassir.MajesticCup.Service.ITeamService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/teams")

public class AdminController {

    private final ITeamService teamService;

    @Autowired
    public AdminController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/addTeam")
    public ResponseEntity<TeamResponseDTO> AddTeam(@RequestBody TeamRequestDTO teamRequestDto) {

        TeamResponseDTO createdTeam = teamService.createTeam(teamRequestDto);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping("allTeams")
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        List<TeamResponseDTO> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

}