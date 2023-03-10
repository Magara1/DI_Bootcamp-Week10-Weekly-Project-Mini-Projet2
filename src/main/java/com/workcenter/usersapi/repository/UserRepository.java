package com.workcenter.usersapi.repository;

import com.workcenter.usersapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
