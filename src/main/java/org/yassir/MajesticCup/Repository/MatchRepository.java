package org.yassir.MajesticCup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yassir.MajesticCup.Model.Entity.Match;

public interface MatchRepository extends MongoRepository<Match, Long> {
}
