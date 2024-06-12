package com.appsdeveloperblog.UserService.RemoteUserStorageService.controller;

import com.appsdeveloperblog.UserService.RemoteUserStorageService.response.UserRest;
import com.appsdeveloperblog.UserService.RemoteUserStorageService.response.VerifyPasswordResponse;
import com.appsdeveloperblog.UserService.RemoteUserStorageService.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserStorageController {

    private final UserService userService;

    public UserStorageController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{userName}")
    public UserRest getUser(@PathVariable("userName") String userName) {

        return userService.getUserDetails(userName);

    }

    @PostMapping("/{userName}/verify-password")
    public VerifyPasswordResponse verifyUserPassword(@PathVariable("userName") String userName,
                                                     @RequestBody String password) {

        VerifyPasswordResponse returnValue = new VerifyPasswordResponse(false);

        UserRest user = userService.getUserDetails(userName, password);

        if (user != null) {
            returnValue.setResult(true);
        }

        return returnValue;
    }
}
