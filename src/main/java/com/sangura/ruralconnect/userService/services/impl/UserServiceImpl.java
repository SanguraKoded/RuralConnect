package com.sangura.ruralconnect.userService.services.impl;

import com.sangura.ruralconnect.userService.dto.UsersDto;
import com.sangura.ruralconnect.userService.entities.Users;
import com.sangura.ruralconnect.userService.mappers.UsersMapper;
import com.sangura.ruralconnect.userService.repo.UserRepo;
import com.sangura.ruralconnect.userService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersMapper usersMapper;
    private final UserRepo userRepo;
    @Override
    @Transactional
    public Users createUsers(UsersDto usersDto) {

        try{
            Users users = usersMapper.toEntity(usersDto);
            return userRepo.save(users);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public Users updateUsers(Long id, UsersDto usersDto) {
        try{
            Users users = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            usersMapper.updateUsersFromDto(usersDto, users);
            return userRepo.save(users);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Users findUsersById(Long id) {
        try{
            return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        try{
            return userRepo.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteUsers(Long id) {
        try{
            userRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            return "Successfully Deleted";
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }
}
