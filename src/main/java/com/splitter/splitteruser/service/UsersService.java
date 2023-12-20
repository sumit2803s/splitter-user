package com.splitter.splitteruser.service;


import com.splitter.splitteruser.model.UserModel;
import com.splitter.splitteruser.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service

public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(String login, String password, String email) {
        if(login!=null && password!=null ) {
            return null;

        } else {

            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return userRepository.save(userModel);




        }
    }
    public UserModel authenticate(String login,String password){
        return userRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}

