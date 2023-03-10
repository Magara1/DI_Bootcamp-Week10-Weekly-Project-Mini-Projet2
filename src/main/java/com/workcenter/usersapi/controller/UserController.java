package com.workcenter.usersapi.controller;

import com.workcenter.usersapi.model.User;
import com.workcenter.usersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userrpository;

    @GetMapping()
    public List<User> findAll(){
        return (List<User>) userrpository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") long id){
        Optional<User> user = userrpository.findById(id);

        if (user.isPresent()){
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<User> save(@Validated @RequestBody User user){
        return new ResponseEntity<>(userrpository.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<User> update(@Validated @RequestBody User user){
        return new ResponseEntity<>(userrpository.save(user), HttpStatus.CREATED);
    }

    @PutMapping()
    public void delete(@Validated @RequestBody User user){
        userrpository.deleteById(user.getId());
    }



}
