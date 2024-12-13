package org.yassir.MajesticCup.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yassir.MajesticCup.Dto.Player.PlayerRequestDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Dto.Round.RoundRequestDTO;
import org.yassir.MajesticCup.Dto.Round.RoundResponseDTO;
import org.yassir.MajesticCup.Model.Entity.Player;
import org.yassir.MajesticCup.Model.Entity.Round;

@Mapper(componentModel = "spring")
public interface IRoundMapper {

    @Mapping(target = "competition", ignore = true)
    @Mapping(target = "matches", ignore = true)
    Round toEntity(RoundRequestDTO roundRequestDTO);

}

