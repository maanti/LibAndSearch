package com.praktos.repository;

import com.praktos.entity.Userr;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Userr,Integer> {

    List<Userr> findUserByUsernameAndPassword(String username, String password);
}
