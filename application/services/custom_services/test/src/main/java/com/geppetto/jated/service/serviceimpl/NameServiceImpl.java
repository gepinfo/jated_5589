package com.geppetto.jated.service.serviceimpl;

import com.geppetto.jated.dao.NameDao;
import com.geppetto.jated.model.Name;
import com.geppetto.jated.dto.NameDto;
import com.geppetto.jated.service.NameService;
import com.geppetto.jated.exception.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService{

      private final NameDao nameDao;

      private final MongoTemplate mongoTemplate;
      public NameServiceImpl(NameDao  nameDao,MongoTemplate mongoTemplate) {
          this. nameDao =  nameDao;
          this.mongoTemplate=mongoTemplate;
}

    @Override
    public NameDto create(NameDto nameDto){
        Name name = new Name();
        BeanUtils.copyProperties(nameDto, name);
        Name createdName= nameDao.create(name);
        BeanUtils.copyProperties(createdName, nameDto);
        return nameDto;
    }


    @Override
    public NameDto getEntityById(String id) {
    NameDto nameDto = new NameDto();
    Optional<Name> result = nameDao.getEntityById(id);
        if (result.isPresent()) {
            BeanUtils.copyProperties(result.get(), nameDto);
        } else {
            throw new EntityNotFoundException("Data not found for ID: " + id);
        }
        return nameDto;
    }


    @Override
    public List<NameDto> getAllValues() {
        List<Name> nameEntities = nameDao.getAllValues();
        List<NameDto> nameDtoList = new ArrayList<>();
        for (Name nameEntity : nameEntities) {
            NameDto nameDto = new NameDto();
            BeanUtils.copyProperties(nameEntity, nameDto);
            nameDtoList.add(nameDto);
        }
        return nameDtoList;
    }



    @Override
    public NameDto update(NameDto nameDto) {
    Optional<Name> result = nameDao.update(nameDto.get_id());
        if (result.isPresent()) {
           Name name = result.get();
           BeanUtils.copyProperties(nameDto, name);
           nameDao.create(name);
           return nameDto;
        } else {
        throw new EntityNotFoundException("Data not found for update with ID: " + nameDto.get_id());
        }
    }


    @Override
    public String delete(String id) {
    Optional<Name> result = nameDao.getEntityById(id);
        if (result.isPresent()) {
            nameDao.delete(id);
        }else{
        throw new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete.");
        }
        return "Data Deleted Successfully";
    }


    @Override
    public List<NameDto> search(Map<String, String> allParams) {
        Query query = new BasicQuery(constructQuery(allParams));
        List<Name> nameEntities= mongoTemplate.find(query, Name.class);
        List<NameDto> nameDtoList = new ArrayList<>();
        for (Name nameEntity : nameEntities) {
             NameDto nameDto = new NameDto();
             BeanUtils.copyProperties(nameEntity, nameDto);
             nameDtoList.add(nameDto);
            }
        return nameDtoList;
    }


    private String constructQuery(Map<String, String> params) {
       StringBuilder queryBuilder = new StringBuilder("{ ");
         for (Map.Entry<String, String> entry : params.entrySet()) {
         queryBuilder.append(entry.getKey()).append(": '").append(entry.getValue()).append("', ");
    }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()).append(" }");
        return queryBuilder.toString();
    }
}