package com.geppetto.jated.dao;

import com.geppetto.jated.model.Name;
import java.util.List;
import java.util.Optional;


public interface NameDao {

    Name create(Name name);


    Optional<Name> getEntityById(String id);


    List<Name> getAllValues();


    Optional<Name> update(String id);


    void delete(String id);

}
