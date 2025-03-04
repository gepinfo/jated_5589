package com.geppetto.jated.service.serviceimpl;

import com.geppetto.jated.dao.UserDao;
import com.geppetto.jated.model.User;
import com.geppetto.jated.dto.UserDto;
import com.geppetto.jated.service.UserService;
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
public class UserServiceImpl implements UserService{

      private final UserDao userDao;

      private final MongoTemplate mongoTemplate;
      public UserServiceImpl(UserDao  userDao,MongoTemplate mongoTemplate) {
          this. userDao =  userDao;
          this.mongoTemplate=mongoTemplate;
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