package dev.antonio.gameLibrary.repository;

import dev.antonio.gameLibrary.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);
}
