package br.com.ciceroednilson.service;

import br.com.ciceroednilson.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleService {

    public Role find(final long personId) {
        log.info("Find role by person id {}", personId);
        return Role.builder()
                .name("Desenvolvedor Backend")
                .description("Responsável pelo desenvolvimento e manutenção da API.")
                .level("Sênior")
                .personId(personId)
                .build();
    }
}
