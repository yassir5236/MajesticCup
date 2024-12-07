package org.yassir.MajesticCup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.yassir.MajesticCup.model.entity.Match;

public interface IMatchRepository extends MongoRepository<Match, Long> {
}
