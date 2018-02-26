package com.praktos.repository;

import com.praktos.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    List<User> findUserByUsernameAndPassword(String username, String password);
}
