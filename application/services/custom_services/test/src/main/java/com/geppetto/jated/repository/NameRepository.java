package com.geppetto.jated.repository;

import com.geppetto.jated.model.Name;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends MongoRepository<Name,String>  {

}
