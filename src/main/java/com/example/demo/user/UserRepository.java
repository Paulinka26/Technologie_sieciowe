package com.example.demo.user;

import com.example.demo.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepository extends CrudRepository<User, Integer>{

}
