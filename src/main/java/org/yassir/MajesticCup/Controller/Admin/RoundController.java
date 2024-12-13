package org.yassir.MajesticCup.Controller.Admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.MajesticCup.Dto.Round.RoundRequestDTO;
import org.yassir.MajesticCup.Model.Entity.Round;
import org.yassir.MajesticCup.Service.IRoundService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rounds")
public class RoundController {
    private final IRoundService roundService;

    public RoundController(IRoundService roundService) {
        this.roundService = roundService;
    }

    @PostMapping
    public ResponseEntity<Round> createRound(@RequestBody RoundRequestDTO roundRequestDTO) {
        return ResponseEntity.ok(roundService.createRound(roundRequestDTO));
    }



    @GetMapping
    public ResponseEntity<List<Round>> getAllRounds() {
        return ResponseEntity.ok(roundService.getAllRounds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getRoundById(@PathVariable String id) {
        return ResponseEntity.ok(roundService.getRoundById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Round> updateRound(
            @PathVariable String id,
            @RequestBody RoundRequestDTO roundRequestDTO) {
        return ResponseEntity.ok(roundService.updateRound(id, roundRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable String id) {
        roundService.deleteRound(id);
        return ResponseEntity.noContent().build();
    }
}
