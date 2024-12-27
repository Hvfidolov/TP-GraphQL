package org.xproce.tprevision.service;

import org.springframework.stereotype.Service;
import org.xproce.tprevision.dao.entities.Phone;
import org.xproce.tprevision.dao.repositories.PhoneRepository;
import org.xproce.tprevision.service.dtos.PhoneDTO;
import org.xproce.tprevision.service.mappers.PhoneMapper;

import java.util.List;

@Service
public class PhoneManagerAction implements PhoneManager{
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public PhoneManagerAction(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

    @Override
    public PhoneDTO savePhone(PhoneDTO phoneDTO) {
        if (phoneRepository.existsByImei(phoneDTO.getIMEI())) {
            throw new RuntimeException("IMEI already exists.");
        }
        Phone phone = phoneMapper.toEntity(phoneDTO);
        phone = phoneRepository.save(phone);
        return phoneMapper.toDTO(phone);
    }

    @Override
    public List<PhoneDTO> getPhoneByModel(String model) {
        List<Phone> phones = phoneRepository.findByModel(model);
        for (Phone phone : phones) {
            phone.toString();
        }
        return phones.stream().map(phoneMapper::toDTO).toList();
    }

    @Override
    public List<PhoneDTO> getPhoneByModelAndPrice(String model, double price) {
        return phoneRepository.findByModelAndPrice(model, price).stream()
                .map(phoneMapper::toDTO)
                .toList();
    }

    @Override
    public PhoneDTO deletePhone(Long id) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new RuntimeException("Phone not found."));
        phoneRepository.delete(phone);
        return phoneMapper.toDTO(phone);
    }
}
