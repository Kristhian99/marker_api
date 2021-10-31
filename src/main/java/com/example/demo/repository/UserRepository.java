package com.example.demo.repository;


import com.example.demo.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User,String>{

     Optional<User> findUserByEmail (String email);

}
