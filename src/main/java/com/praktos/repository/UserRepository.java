package com.praktos.repository;

import com.praktos.entity.Userr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<Userr,Integer> {

    List<Userr> findUserrByUsernameAndPassword(String username, String password);
}
