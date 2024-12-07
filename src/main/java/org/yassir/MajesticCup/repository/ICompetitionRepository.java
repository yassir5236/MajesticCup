package org.yassir.MajesticCup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yassir.MajesticCup.model.entity.Competition;

public interface ICompetitionRepository extends MongoRepository<Competition,String> {
}
