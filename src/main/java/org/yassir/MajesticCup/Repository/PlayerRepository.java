package org.yassir.MajesticCup.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yassir.MajesticCup.Model.Entity.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

}
