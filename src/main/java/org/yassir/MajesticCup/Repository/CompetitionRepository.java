package org.yassir.MajesticCup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yassir.MajesticCup.Model.Entity.Competition;

public interface CompetitionRepository extends MongoRepository<Competition,String> {
}
