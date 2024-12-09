package org.yassir.MajesticCup.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.MajesticCup.Dto.Player.PlayerRequestDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Service.IPlayerService;


import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final IPlayerService playerService;

    @Autowired
    public PlayerController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> createPlayer(@Valid @RequestBody PlayerRequestDTO playerRequestDTO) {
        PlayerResponseDTO createdPlayer = playerService.createPlayer(playerRequestDTO);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PlayerResponseDTO> getPlayerById(@PathVariable Long id) {
//        PlayerResponseDTO player = playerService.getPlayerById(id);
//        return ResponseEntity.ok(player);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<PlayerResponseDTO> updatePlayer(
//            @PathVariable Long id,
//            @Valid @RequestBody PlayerRequestDTO playerRequestDTO) {
//        PlayerResponseDTO updatedPlayer = playerService.updatePlayer(id, playerRequestDTO);
//        return ResponseEntity.ok(updatedPlayer);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
//        playerService.deletePlayer(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<PlayerResponseDTO>> getAllPlayers() {
//        List<PlayerResponseDTO> players = playerService.getAllPlayers();
//        return ResponseEntity.ok(players);
//    }




}

