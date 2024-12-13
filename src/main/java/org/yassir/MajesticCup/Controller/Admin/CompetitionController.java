package org.yassir.MajesticCup.Controller.Admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.MajesticCup.Dto.Competition.CompetitionRequestDTO;
import org.yassir.MajesticCup.Model.Entity.Competition;
import org.yassir.MajesticCup.Service.ICompetitionService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/competitions")
public class CompetitionController {
    private final ICompetitionService competitionService;

    public CompetitionController(ICompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping
    public ResponseEntity<Competition> createCompetition(@RequestBody CompetitionRequestDTO competitionRequestDTO) {
        return ResponseEntity.ok(competitionService.createCompetition(competitionRequestDTO));
    }




    @GetMapping
    public ResponseEntity<List<Competition>> getAllCompetitiones() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable String id) {
        return ResponseEntity.ok(competitionService.getCompetitionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(
            @PathVariable String id,
            @RequestBody CompetitionRequestDTO competitionRequestDTO) {
        return ResponseEntity.ok(competitionService.updateCompetition(id, competitionRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable String id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.noContent().build();
    }
}
