package eus.birt.ad7.repository;

import eus.birt.ad7.domain.Crag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CragRepository extends MongoRepository<Crag, String> {
}
