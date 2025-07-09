package br.com.ciceroednilson.service;

import br.com.ciceroednilson.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddressService {

    public Address find(final long personId) {
        log.info("Find address by person id {}", personId);
        return Address.builder()
                .street("Avenida Paulista")
                .number("1000")
                .complement("Apto 101")
                .neighborhood("Bela Vista")
                .city("São Paulo")
                .state("SP")
                .postalCode("01310-100")
                .country("Brasil")
                .personId(personId)
                .build();
    }
}
