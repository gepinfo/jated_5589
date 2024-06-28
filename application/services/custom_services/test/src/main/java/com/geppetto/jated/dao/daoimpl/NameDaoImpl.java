package com.geppetto.jated.dao.daoimpl;

import com.geppetto.jated.model.Name;
import com.geppetto.jated.repository.NameRepository;
import com.geppetto.jated.dao.NameDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class NameDaoImpl implements NameDao{

    private final NameRepository nameRepository;

     public NameDaoImpl(NameRepository nameRepository) {
       this.nameRepository = nameRepository;
}

    @Override
    public Name create(Name name) {
      return nameRepository.save(name);
    }


    @Override
    public Optional<Name> getEntityById(String id) {
      return nameRepository.findById(id);
    }


    @Override
    public List<Name> getAllValues() {
      return nameRepository.findAll();
    }


    @Override
    public Optional<Name> update(String id) {
      return nameRepository.findById(id);
    }


    @Override
    public void delete(String id) {
      nameRepository.deleteById(id);
    }

}
