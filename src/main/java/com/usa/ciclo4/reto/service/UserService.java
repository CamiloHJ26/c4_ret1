package com.usa.ciclo4.reto.service;

import com.usa.ciclo4.reto.model.User;
import com.usa.ciclo4.reto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers () {
        return userRepository.getAllUsers();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public void save(User user){
        if(user.getId()==null){
            userRepository.save(user);
        }else if (!userRepository.getUser(user.getId()).isPresent()){
            userRepository.save(user);
        }
    }

    public boolean emailExists(String email){
        if(!userRepository.emailExists(email).isPresent()){
            return false;
        }
        return true;
    }

    public Optional<User> login (String email,String password){
        Optional<User> user = userRepository.login(email,password);
        if(!user.isPresent()){
            return Optional.of(new User(null,email,password,"NO DEFINIDO"));
        }
        return user;
    }
}
