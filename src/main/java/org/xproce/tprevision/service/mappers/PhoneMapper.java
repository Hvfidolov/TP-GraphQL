package org.xproce.tprevision.service.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.xproce.tprevision.dao.entities.Phone;
import org.xproce.tprevision.service.dtos.PhoneDTO;

@Component
public class PhoneMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    public PhoneDTO toDTO(Phone phone) {
        return modelMapper.map(phone, PhoneDTO.class);
    }

    public Phone toEntity(PhoneDTO phoneDTO) {
        return modelMapper.map(phoneDTO, Phone.class);
    }
}
