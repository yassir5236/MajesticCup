package org.yassir.MajesticCup.Dto.Round;

import java.util.List;

public record RoundRequestDTO(
         int roundNumber,
         String competition,
         List <String> matches

) {}
