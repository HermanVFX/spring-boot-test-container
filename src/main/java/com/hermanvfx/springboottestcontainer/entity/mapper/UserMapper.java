package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.UserDto;
import com.hermanvfx.springboottestcontainer.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User entity);
    List<UserDto> userListToUserDtoList(List<User> entityList);
}
