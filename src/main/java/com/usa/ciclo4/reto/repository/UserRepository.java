package com.usa.ciclo4.reto.repository;

import com.usa.ciclo4.reto.model.User;
import com.usa.ciclo4.reto.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAllUsers(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public User save(User user){
        return userCrudRepository.save(user);
    }

    public Optional<User> emailExists(String email){
        return userCrudRepository.findByEmail(email);
    }

    public Optional<User> login (String email,String password){
        return userCrudRepository.findByEmailAndPassword(email,password);
    }
}
