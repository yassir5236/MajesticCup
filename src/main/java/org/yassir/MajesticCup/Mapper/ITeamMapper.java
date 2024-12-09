package org.yassir.MajesticCup.Mapper;

import org.mapstruct.Mapper;
import org.yassir.MajesticCup.Dto.Team.TeamRequestDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;
import org.yassir.MajesticCup.Model.Entity.Team;

@Mapper(componentModel = "spring")
public interface ITeamMapper {
    Team toEntity (TeamRequestDTO teamRequestDTO);
    TeamResponseDTO toResponseDto (Team team);
}
