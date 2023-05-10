package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.ShortPhoneDto;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Phone shortPhoneDtoToPhone(ShortPhoneDto dto);
    List<Phone> listShortPhoneDtoToListPhone(List<ShortPhoneDto> dtos);
}
