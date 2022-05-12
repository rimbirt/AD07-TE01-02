package eus.birt.ad7.repository;

import eus.birt.ad7.domain.Climber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimberRepository extends MongoRepository<Climber, String> {
}
