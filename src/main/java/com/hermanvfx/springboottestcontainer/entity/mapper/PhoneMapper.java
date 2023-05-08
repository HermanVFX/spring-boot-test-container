package com.hermanvfx.springboottestcontainer.entity.mapper;

import com.hermanvfx.springboottestcontainer.dto.ShortPhoneDto;
import com.hermanvfx.springboottestcontainer.entity.Phone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    Phone shortPhoneDtoToPhone(ShortPhoneDto dto);
    List<Phone> listShortPhoneDtoToListPhone(List<ShortPhoneDto> dtos);
}
