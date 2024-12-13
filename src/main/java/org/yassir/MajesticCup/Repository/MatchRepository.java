package org.yassir.MajesticCup.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yassir.MajesticCup.Model.Entity.Match;

import java.util.List;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {

}
