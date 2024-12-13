package org.yassir.MajesticCup.Model.Entity;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.yassir.MajesticCup.Repository.PlayerRepository;
import org.yassir.MajesticCup.Repository.TeamRepository;

@Component
public class PlayerMapperHelper {
    private final PlayerRepository playerRepository;

    public PlayerMapperHelper(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Named("stringToPlayer")
    public Player map(String playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found: " + playerId));
    }
}

