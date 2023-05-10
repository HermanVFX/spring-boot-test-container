package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.ShortEmailDto;
import com.hermanvfx.springboottestcontainer.entity.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Email shortEmailDtoToEmail(ShortEmailDto dto);
    List<Email> listShortEmailDtoToListEmail(List<ShortEmailDto> dtos);
}
