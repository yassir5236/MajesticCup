package org.yassir.MajesticCup.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yassir.MajesticCup.Dto.Match.MatchRequestDTO;
import org.yassir.MajesticCup.Dto.Match.MatchResponseDTO;
import org.yassir.MajesticCup.Model.Entity.Match;
import org.yassir.MajesticCup.Model.Entity.PlayerMapperHelper;
import org.yassir.MajesticCup.Model.Entity.TeamMapperHelper;

//@Mapper(componentModel = "spring", uses = {TeamMapperHelper.class, PlayerMapperHelper.class})
//public interface IMatchMapper {
//
//    @Mapping(source = "team1", target = "team1", qualifiedByName = "stringToTeam")
//    @Mapping(source = "team2", target = "team2", qualifiedByName = "stringToTeam")
//    @Mapping(source = "winner", target = "winner", qualifiedByName = "stringToPlayer")
//    Match toEntity(MatchRequestDTO matchRequestDTO);
//
//    MatchResponseDTO toResponseDTO(Match match);
//}



@Mapper(componentModel = "spring", uses = {TeamMapperHelper.class, PlayerMapperHelper.class})
public interface IMatchMapper {

    @Mapping(source = "team1", target = "team1", qualifiedByName = "stringToTeam")
    @Mapping(source = "team2", target = "team2", qualifiedByName = "stringToTeam")
    @Mapping(source = "winner", target = "winner", qualifiedByName = "stringToPlayer")
    Match toEntity(MatchRequestDTO matchRequestDTO);

    MatchResponseDTO toResponseDTO(Match match);
}


