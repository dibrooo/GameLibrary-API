package dev.antonio.gameLibrary.repository;

import dev.antonio.gameLibrary.entity.Games;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends MongoRepository<Games, ObjectId> {
}
