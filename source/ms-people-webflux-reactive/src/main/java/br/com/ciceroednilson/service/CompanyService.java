package br.com.ciceroednilson.service;

import br.com.ciceroednilson.model.Address;
import br.com.ciceroednilson.model.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompanyService {

    public Company find(final long personId) {
        log.info("Find company by person id {}", personId);
        final Address address = Address.builder()
                .street("Avenida das Nações Unidas")
                .number("5000")
                .complement("Torre A, 15º andar")
                .neighborhood("Brooklin")
                .city("São Paulo")
                .state("SP")
                .postalCode("04578-000")
                .country("Brasil")
                .personId(null)
                .build();
        return Company.builder()
                .id(10L)
                .name("Tech Solutions Ltda.")
                .cnpj("12.345.678/0001-90")
                .industry("Tecnologia da Informação")
                .email("contato@techsolutions.com.br")
                .phone("+55 (11) 4002-8922")
                .address(address)
                .personId(personId)
                .build();
    }
}
