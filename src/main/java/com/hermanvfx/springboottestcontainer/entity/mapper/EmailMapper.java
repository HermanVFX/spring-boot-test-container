package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.ShortEmailDto;
import com.hermanvfx.springboottestcontainer.entity.Email;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    Email shortEmailDtoToEmail(ShortEmailDto dto);
    List<Email> listShortEmailDtoToListEmail(List<ShortEmailDto> dtos);
}
