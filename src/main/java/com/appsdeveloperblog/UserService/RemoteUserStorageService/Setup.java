package com.appsdeveloperblog.UserService.RemoteUserStorageService;

import com.appsdeveloperblog.UserService.RemoteUserStorageService.model.UserEntity;
import com.appsdeveloperblog.UserService.RemoteUserStorageService.model.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Setup {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        UserEntity user = new UserEntity(
                1L,
                "qswe3mg84mfjtu",
                "Abhay",
                "Gupta",
                "test2@test.com",
                bCryptPasswordEncoder.encode("abhay"),
                "",
                false);

        userRepository.save(user);
    }
}
