package org.xproce.tprevision.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.tprevision.dao.entities.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByModel(String model);
    List<Phone> findByModelAndPrice(String model, double price);
    boolean existsByIMEI(String IMEI);
}
