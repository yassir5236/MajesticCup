package org.yassir.MajesticCup.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yassir.MajesticCup.Dto.Competition.CompetitionRequestDTO;
import org.yassir.MajesticCup.Dto.Competition.CompetitionResponseDTO;
import org.yassir.MajesticCup.Model.Entity.CompetitionMapperHelper;
import org.yassir.MajesticCup.Model.Entity.MatchMapperHelper;
import org.yassir.MajesticCup.Model.Entity.Competition;



@Mapper(componentModel = "spring")
public interface ICompetitionMapper {

    @Mapping(target = "teams", ignore = true)  // Ignore le champ teams
    @Mapping(target = "rounds", ignore = true) // Ignore le champ rounds
    Competition toEntity(CompetitionRequestDTO competitionRequestDTO);

}
