package org.yassir.MajesticCup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yassir.MajesticCup.model.entity.Team;

public interface ITeamRepository extends MongoRepository<Team,String> {
}
