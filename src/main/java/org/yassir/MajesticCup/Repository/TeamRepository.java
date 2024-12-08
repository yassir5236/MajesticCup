package org.yassir.MajesticCup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yassir.MajesticCup.Model.Entity.Team;

public interface TeamRepository extends MongoRepository<Team,String> {
}
