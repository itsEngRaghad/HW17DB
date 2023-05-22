package com.example.dbhw17.Service;

import com.example.dbhw17.Model.User;
import com.example.dbhw17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //get
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //add user

    public void addUser(User user){
        userRepository.save(user);
    }

    //update
    public boolean updateUser(User user, Integer id){
        User oldUser=userRepository.getById(id);
        if(oldUser==null){
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser); //save it in the olduser
        return true;
    }

    //Delete
    public boolean deleteUser(Integer id){
        User oldUser=userRepository.getById(id);
        if(oldUser==null){
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }
}
