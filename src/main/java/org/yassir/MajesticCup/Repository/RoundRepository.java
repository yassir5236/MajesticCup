package org.yassir.MajesticCup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yassir.MajesticCup.Model.Entity.Round;

public interface RoundRepository extends MongoRepository<Round, Long> {
}
