package org.yassir.MajesticCup.Dto.Player;

public record PlayerRequestDTO(

         String name,
         String surname,
         String position,
         int number,
         String teamId
) {
}
