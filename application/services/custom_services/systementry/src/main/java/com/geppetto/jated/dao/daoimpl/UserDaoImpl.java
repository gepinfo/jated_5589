package com.geppetto.jated.dao.daoimpl;

import com.geppetto.jated.model.User;
import com.geppetto.jated.repository.UserRepository;
import com.geppetto.jated.dao.UserDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{

    private final UserRepository userRepository;

     public UserDaoImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
}





}
