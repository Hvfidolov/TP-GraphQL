package org.xproce.tprevision.web;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.xproce.tprevision.service.PhoneManager;
import org.xproce.tprevision.service.dtos.PhoneDTO;

import java.util.List;

@Controller
public class PhoneGraphQLController {
    private final PhoneManager phoneManager;

    public PhoneGraphQLController(PhoneManager phoneManager) {
        this.phoneManager = phoneManager;
    }

    @QueryMapping
    public List<PhoneDTO> getPhoneByModel(@Argument("model") String model) {
        return phoneManager.getPhoneByModel(model);
    }

    @QueryMapping
    public List<PhoneDTO> getPhoneByModelAndPrice(@Argument("model") String model,@Argument("price") double price) {
        return phoneManager.GetPhoneByModelAndPrice(model, price);
    }

    @MutationMapping
    public PhoneDTO savePhone(PhoneDTO phone) {
        return phoneManager.savePhone(phone);
    }

    @MutationMapping
    public PhoneDTO deletePhone(Long id) {
        return phoneManager.deletePhone(id);
    }
}
