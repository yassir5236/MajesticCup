package org.yassir.MajesticCup.Controller.Operator;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.MajesticCup.Dto.Match.MatchRequestDTO;
import org.yassir.MajesticCup.Dto.Match.MatchResponseDTO;
import org.yassir.MajesticCup.Model.Entity.Match;
import org.yassir.MajesticCup.Service.IMatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operator/matches/result")
public class MatchController {
    private final IMatchService matchService;

    public MatchController(IMatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<MatchResponseDTO> createMatch(@RequestBody MatchRequestDTO matchRequestDTO) {
        return ResponseEntity.ok(matchService.createMatch(matchRequestDTO));
    }



    @GetMapping
    public ResponseEntity<List<MatchResponseDTO>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable String id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<MatchResponseDTO> updateMatch(
//            @PathVariable String id,
//            @RequestBody MatchRequestDTO matchRequestDTO) {
//        return ResponseEntity.ok(matchService.updateMatch(id, matchRequestDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMatch(@PathVariable String id) {
//        matchService.deleteMatch(id);
//        return ResponseEntity.noContent().build();
//    }
}
