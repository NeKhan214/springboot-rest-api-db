package com.nehak.springbootrestapidb.mapper;

import com.nehak.springbootrestapidb.dto.UserDto;
import com.nehak.springbootrestapidb.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
