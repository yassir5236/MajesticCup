package org.yassir.MajesticCup.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yassir.MajesticCup.Dto.Player.PlayerRequestDTO;
import org.yassir.MajesticCup.Dto.Player.PlayerResponseDTO;
import org.yassir.MajesticCup.Model.Entity.Player;

@Mapper(componentModel = "spring")
public interface IPlayerMapper {

    Player toEntity(PlayerRequestDTO playerRequestDTO);
    PlayerResponseDTO toResponseDto(Player player);
}