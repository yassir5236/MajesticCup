package org.yassir.MajesticCup.Dto.Round;

import java.util.List;

public record RoundResponseDTO(
        String id,
        int roundNumber,
        String competition,
        List <String> matches
) {
}


