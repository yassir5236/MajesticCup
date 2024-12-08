package org.yassir.MajesticCup.Repository;


import org.springframework.stereotype.Repository;
import org.yassir.MajesticCup.Model.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
