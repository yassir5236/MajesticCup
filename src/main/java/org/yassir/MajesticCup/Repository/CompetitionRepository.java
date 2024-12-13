package org.yassir.MajesticCup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yassir.MajesticCup.Model.Entity.Competition;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition,String> {
}
