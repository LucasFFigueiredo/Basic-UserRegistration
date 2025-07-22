package com.cbase.userregistration.business;

import com.cbase.userregistration.configuration.entitys.User;
import com.cbase.userregistration.configuration.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.saveAndFlush(user);
    }

    public User findUserById(Integer id){

        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    public void deleteUserById(Integer id){
        repository.deleteById(id);
    }

    public void updateUserById(Integer id, User user){
        User userEntity = repository.findById(id).orElseThrow(() ->
        new RuntimeException("User not found"));

        User userUpdate = User.builder()
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .adress(user.getAdress() != null ? user.getAdress() : userEntity.getAdress())
                        .cpf(userEntity.getCpf())
                        .id(userEntity.getId())
                        .build();

        repository.saveAndFlush(userUpdate);
    }


}
