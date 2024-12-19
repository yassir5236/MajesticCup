package org.yassir.MajesticCup.Controller.Public;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yassir.MajesticCup.Dto.PlayerStatisticsDTO.PlayerStatisticsDTO;
import org.yassir.MajesticCup.Service.Impl.PlayerStatisticsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/public/statistics")
public class PlayerStatisticsController {

    private final PlayerStatisticsServiceImpl playerStatisticsService;

    public PlayerStatisticsController(PlayerStatisticsServiceImpl playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @GetMapping("/top-scorers")
    public List<PlayerStatisticsDTO> getTopScorers() {
        return playerStatisticsService.getTopScorers();
    }

    @GetMapping("/top-assists")
    public List<PlayerStatisticsDTO> getTopAssists() {
        return playerStatisticsService.getTopAssists();
    }

//    @GetMapping("/cards")
//    public List<PlayerStatisticsDTO> getTopCards() {
//        return playerStatisticsService.getTopCards();
//    }
}
