package com.sangura.ruralconnect.userService.mappers;

import com.sangura.ruralconnect.userService.dto.UsersDto;
import com.sangura.ruralconnect.userService.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    default Users toEntity(UsersDto usersDto){
        if(usersDto==null){
            return null;
        }
        Users users = new Users();
        users.setEmail(usersDto.getEmail());
        users.setUsername(usersDto.getUsername());
        users.setPassword(usersDto.getPassword());
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setOrderedItems(usersDto.getOrderedItems());
        return users;
    };

    default UsersDto toDto(Users users){
        if(users==null){
            return null;
        }
        UsersDto usersDto = new UsersDto();
        usersDto.setEmail(users.getEmail());
        usersDto.setUsername(users.getUsername());
        usersDto.setPassword(users.getPassword());
        usersDto.setPhoneNumber(users.getPhoneNumber());
        usersDto.setOrderedItems(users.getOrderedItems());
        return usersDto;
    };

    @Mapping(target="customerId", ignore = true)
    Users updateUsersFromDto(UsersDto usersDto, @MappingTarget Users users);
}
