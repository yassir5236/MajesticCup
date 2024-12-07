package org.yassir.MajesticCup.repository;


import org.yassir.MajesticCup.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, Integer> {
    User findByUsername(String username);
}
