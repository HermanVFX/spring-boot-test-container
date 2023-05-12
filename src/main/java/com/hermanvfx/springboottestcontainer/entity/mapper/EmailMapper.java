package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.ShortEmailDto;
import com.hermanvfx.springboottestcontainer.dto.ShortPhoneDto;
import com.hermanvfx.springboottestcontainer.entity.Email;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Email shortEmailDtoToEmail(ShortEmailDto dto);
    List<ShortEmailDto> listEmailToListShortEmailDto(List<Email> entity);
    List<Email> listShortEmailDtoToListEmail(List<ShortEmailDto> dtos);
}
