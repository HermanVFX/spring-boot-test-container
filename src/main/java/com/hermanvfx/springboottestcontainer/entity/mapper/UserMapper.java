package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.FullUserDto;
import com.hermanvfx.springboottestcontainer.dto.ShortEmailDto;
import com.hermanvfx.springboottestcontainer.dto.ShortPhoneDto;
import com.hermanvfx.springboottestcontainer.dto.UserDto;
import com.hermanvfx.springboottestcontainer.dto.UserFullDtoPage;
import com.hermanvfx.springboottestcontainer.entity.Email;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import com.hermanvfx.springboottestcontainer.entity.User;
import com.hermanvfx.springboottestcontainer.entity.UserInfo;
import org.mapstruct.BeforeMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                PhoneMapper.class,
                EmailMapper.class
        })
public interface UserMapper {

    UserDto userToUserDto(User entity);
    List<UserDto> userListToUserDtoList(List<User> entityList);

    UserFullDtoPage pageUserInfoToUserFullDtoPage (Page<UserInfo> userInfoPage);

    List<FullUserDto> userInfoToFullUserDto(List<UserInfo> userInfo);
}
