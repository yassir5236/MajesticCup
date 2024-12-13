package org.yassir.MajesticCup.Service;

import org.yassir.MajesticCup.Dto.Round.RoundRequestDTO;
import org.yassir.MajesticCup.Model.Entity.Round;

import java.util.List;

public interface IRoundService {

    Round createRound(RoundRequestDTO roundRequestDTO);

    Round getRoundById(String roundId);
    Round updateRound(String id, RoundRequestDTO roundRequestDTO);
    List<Round> getAllRounds();

    void deleteRound(String roundId);



}
