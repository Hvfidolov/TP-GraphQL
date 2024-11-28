package org.xproce.tprevision.service;

import org.xproce.tprevision.service.dtos.PhoneDTO;

import java.util.List;

public interface PhoneManager {
    PhoneDTO savePhone(PhoneDTO phoneDTO);
    List<PhoneDTO> getPhoneByModel(String model);
    List<PhoneDTO> GetPhoneByModelAndPrice(String model, double price);
    PhoneDTO deletePhone(Long id);
}
