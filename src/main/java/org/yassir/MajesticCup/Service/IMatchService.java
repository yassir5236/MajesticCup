package org.yassir.MajesticCup.Service;

import org.bson.types.ObjectId;
import org.yassir.MajesticCup.Dto.Match.MatchRequestDTO;
import org.yassir.MajesticCup.Dto.Match.MatchResponseDTO;
import org.yassir.MajesticCup.Model.Entity.Match;

import java.util.List;



public interface IMatchService {
    MatchResponseDTO createMatch(MatchRequestDTO matchRequestDTO);
//    Match createMatch(Match match);

//    MatchResponseDTO updateMatch(String id, MatchRequestDTO matchRequestDTO);
//    void deleteMatch(String id);
    MatchResponseDTO getMatchById(String id);
    List<MatchResponseDTO> getAllMatches();
//    List<MatchResponseDTO> getMatchesByRound(int round);
}
