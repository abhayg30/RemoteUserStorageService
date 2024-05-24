package com.appsdeveloperblog.UserService.RemoteUserStorageService.service;

import com.appsdeveloperblog.UserService.RemoteUserStorageService.response.UserRest;

public interface UserService {
    public UserRest getUserDetails(String userName, String password);
    public UserRest getUserDetails(String userName);
}
