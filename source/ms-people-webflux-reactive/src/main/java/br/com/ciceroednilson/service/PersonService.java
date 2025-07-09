package br.com.ciceroednilson.service;

import br.com.ciceroednilson.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {

    public Person find(final long id) {
        log.info("Find a person by {}", id);
        return Person.builder()
                .id(id)
                .firstName("Cícero")
                .lastName("Ednilson")
                .age(30)
                .email("ciceroednilson@email.com")
                .build();
    }
}
