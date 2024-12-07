package org.yassir.MajesticCup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.yassir.MajesticCup.model.entity.Round;

public interface IRoundRepository extends MongoRepository<Round, Long> {
}
