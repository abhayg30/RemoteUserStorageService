package com.appsdeveloperblog.UserService.RemoteUserStorageService.service;

import com.appsdeveloperblog.UserService.RemoteUserStorageService.model.UserEntity;
import com.appsdeveloperblog.UserService.RemoteUserStorageService.model.UserRepository;
import com.appsdeveloperblog.UserService.RemoteUserStorageService.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository usersRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserRest getUserDetails(String userName, String password) {
       return new UserRest();
    }

    @Override
    public UserRest getUserDetails(String userName) {
        UserEntity userEntity = usersRepository.findByEmail(userName);
        if(userEntity == null){
            return new UserRest();
        }
        UserRest userRest = new UserRest();
        BeanUtils.copyProperties(userEntity, userRest);
        return userRest;
    }
}
