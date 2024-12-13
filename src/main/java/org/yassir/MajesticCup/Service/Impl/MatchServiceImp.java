//package org.yassir.MajesticCup.Service.Impl;
//
//import org.springframework.stereotype.Service;
//import org.yassir.MajesticCup.Dto.Match.MatchRequestDTO;
//import org.yassir.MajesticCup.Dto.Match.MatchResponseDTO;
//import org.yassir.MajesticCup.Mapper.IMatchMapper;
//import org.yassir.MajesticCup.Model.Entity.Match;
//import org.yassir.MajesticCup.Model.Entity.Team;
//import org.yassir.MajesticCup.Repository.MatchRepository;
//import org.yassir.MajesticCup.Repository.TeamRepository;
//import org.yassir.MajesticCup.Service.IMatchService;
//
//import java.util.List;
////
////@Service
////public class MatchServiceImpl implements IMatchService {
////
////    private final MatchRepository matchRepository;
////    private final IMatchMapper matchMapper;
////    private final TeamRepository teamRepository;
////
////    public MatchServiceImpl(MatchRepository matchRepository, IMatchMapper matchMapper, TeamRepository teamRepository) {
////        this.matchRepository = matchRepository;
////        this.matchMapper = matchMapper;
////        this.teamRepository = teamRepository;
////    }
////
////
////
////    @Override
////    public MatchResponseDTO createMatch(MatchRequestDTO matchRequestDTO) {
////        Team team1 = teamRepository.findById(matchRequestDTO.team1())
////                .orElseThrow(() -> new RuntimeException("Team not found with id: " + matchRequestDTO.team1()));
////        Team team2 = teamRepository.findById(matchRequestDTO.team2())
////                .orElseThrow(() -> new RuntimeException("Team not found with id: " + matchRequestDTO.team2()));
////
////        Match match = matchMapper.toEntity(matchRequestDTO);
////        match.setTeam1(team1);
////        match.setTeam2(team2);
////
////        Match savedMatch = matchRepository.save(match);
////        return matchMapper.toResponseDto(savedMatch);
////    }
////
////
////
////    @Override
////    public MatchResponseDTO updateMatch(String id, MatchRequestDTO matchRequestDTO) {
////        // Vérifier si le match existe
////        Match existingMatch = matchRepository.findById(id)
////                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));
////
////        // Rechercher les équipes par leurs IDs
////        Team team1 = teamRepository.findById(matchRequestDTO.team1())
////                .orElseThrow(() -> new RuntimeException("Team 1 not found with id: " + matchRequestDTO.team1()));
////
////        Team team2 = teamRepository.findById(matchRequestDTO.team2())
////                .orElseThrow(() -> new RuntimeException("Team 2 not found with id: " + matchRequestDTO.team2()));
////
////        // Mettre à jour les champs du match
////        existingMatch.setRound(matchRequestDTO.round());
////        existingMatch.setTeam1(team1);
////        existingMatch.setTeam2(team2);
//////        existingMatch.setResult(matchRequestDTO.result());
//////        existingMatch.setWinner(matchRequestDTO.winner());
////
////        // Sauvegarder les changements
////        Match savedMatch = matchRepository.save(existingMatch);
////
////        // Retourner le DTO de réponse
////        return matchMapper.toResponseDto(savedMatch);
////    }
////
////
////    @Override
////    public void deleteMatch(String id) {
////        if (!matchRepository.existsById(id)) {
////            throw new RuntimeException("Match not found with id: " + id);
////        }
////        matchRepository.deleteById(id);
////    }
////
////    @Override
////    public MatchResponseDTO getMatchById(String id) {
////        Match match = matchRepository.findById(id)
////                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));
////        return matchMapper.toResponseDto(match);
////    }
////
////    @Override
////    public List<MatchResponseDTO> getAllMatches() {
////        List<Match> matches = matchRepository.findAll();
////        return matches.stream()
////                .map(matchMapper::toResponseDto)
////                .toList();
////    }
////
////    @Override
////    public List<MatchResponseDTO> getMatchesByRound(int round) {
////        List<Match> matches = matchRepository.findByRound(round);
////        return matches.stream()
////                .map(matchMapper::toResponseDto)
////                .toList();
////    }
////}
////
//
//
//
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.yassir.MajesticCup.Dto.Match.MatchRequestDTO;
//import org.yassir.MajesticCup.Dto.Match.MatchResponseDTO;
//import org.yassir.MajesticCup.Mapper.IMatchMapper;
//import org.yassir.MajesticCup.Model.Entity.Match;
//import org.yassir.MajesticCup.Repository.MatchRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class MatchServiceImpl implements IMatchService {
//
//    private final MatchRepository matchRepository;
//    private final IMatchMapper matchMapper;
//    private final TeamRepository teamRepository;
//
//    public MatchServiceImpl(MatchRepository matchRepository, IMatchMapper matchMapper, TeamRepository teamRepository) {
//        this.matchRepository = matchRepository;
//        this.matchMapper = matchMapper;
//        this.teamRepository = teamRepository;
//    }
//
//    @Override
//    public List<MatchResponseDTO> getAllMatches() {
//        List<Match> matches = matchRepository.findAll();
//        return matches.stream()
//                .map(matchMapper::toResponseDto)
//                .collect(Collectors.toList());
//    }
//
////    @Override
////    public Optional<MatchResponseDTO> getMatchById(ObjectId id) {
////        Optional<Match> match = matchRepository.findById(id);
////        return match.map(matchMapper::toResponseDto);
////    }
//
//    @Override
//    public MatchResponseDTO createMatch(MatchRequestDTO matchRequestDTO) {
//        Match match = matchMapper.toEntity(matchRequestDTO);
//        Match savedMatch = matchRepository.save(match);
//        return matchMapper.toResponseDto(savedMatch);
//    }
//
//    @Override
//    public MatchResponseDTO updateMatch(ObjectId id, MatchRequestDTO matchRequestDTO) {
//        Match match = matchMapper.toEntity(matchRequestDTO);
//        match.setId(id); // Assurez-vous que l'ID est défini pour la mise à jour
//        Match updatedMatch = matchRepository.save(match);
//        return matchMapper.toResponseDto(updatedMatch);
//    }
//
//    @Override
//    public void deleteMatch(ObjectId id) {
//        matchRepository.deleteById(id);
//    }
//}
//

package org.yassir.MajesticCup.Service.Impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Dto.Match.MatchRequestDTO;
import org.yassir.MajesticCup.Dto.Match.MatchResponseDTO;
import org.yassir.MajesticCup.Dto.Team.TeamResponseDTO;
import org.yassir.MajesticCup.Mapper.IMatchMapper;
import org.yassir.MajesticCup.Model.Entity.Match;
import org.yassir.MajesticCup.Model.Entity.Player;
import org.yassir.MajesticCup.Model.Entity.Team;
import org.yassir.MajesticCup.Repository.MatchRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.yassir.MajesticCup.Repository.PlayerRepository;
import org.yassir.MajesticCup.Repository.TeamRepository;
import org.yassir.MajesticCup.Service.IMatchService;

import java.util.List;

@Service
public class MatchServiceImp implements IMatchService {
    private final MatchRepository matchRepository;
    private final IMatchMapper matchMapper;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public MatchServiceImp(MatchRepository matchRepository, TeamRepository teamRepository , IMatchMapper matchMapper, PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }
    public MatchResponseDTO createMatch(MatchRequestDTO matchRequestDTO) {
        Match match = matchMapper.toEntity(matchRequestDTO);

        Team team1 =teamRepository.findById(matchRequestDTO.team1())
                .orElseThrow(()->new RuntimeException("Team not found"));

        Team team2 =teamRepository.findById(matchRequestDTO.team1())
                .orElseThrow(()->new RuntimeException("Team not found"));

        Player winner = playerRepository.findById(matchRequestDTO.winner())
                .orElseThrow(()->new RuntimeException("Player not found"));

        match.setTeam1(team1);
        match.setTeam1(team2);
        match.setWinner(winner);

         Match createdMatch  = matchRepository.save(match);
        return matchMapper.toResponseDTO(createdMatch);
    }


    public List<MatchResponseDTO> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream()
                .map(matchMapper::toResponseDTO)
                .toList();
    }

    public MatchResponseDTO getMatchById(String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        return matchMapper.toResponseDTO(match);
    }
//
//    public MatchResponseDTO updateMatch(String id, MatchRequestDTO matchRequestDTO) {
//        Match existingMatch = matchRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Match not found"));
//        Match updatedMatch = matchMapper.toEntity(matchRequestDTO);
//        updatedMatch.setId(existingMatch.getId());
//        Match savedMatch = matchRepository.save(updatedMatch);
//        return matchMapper.toResponseDTO(savedMatch);
//    }
//
//    public void deleteMatch(String id) {
//        matchRepository.deleteById(id);
//    }

}

