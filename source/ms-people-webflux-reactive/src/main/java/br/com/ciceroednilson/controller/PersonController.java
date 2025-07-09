package br.com.ciceroednilson.controller;

import br.com.ciceroednilson.model.Person;
import br.com.ciceroednilson.response.PersonResponse;
import br.com.ciceroednilson.service.ProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final ProcessService service;

    public PersonController(final ProcessService service) {
        this.service = service;
    }

    @GetMapping("/find")
    public Mono<PersonResponse> find() {
        return this.service.findZip();
    }

    @GetMapping("/find-just/{id}")
    public Mono<PersonResponse> findJust(@PathVariable final long id) {
        return this.service.findUsingJust(id);
    }

    @GetMapping("/find-map/{id}")
    public Mono<ResponseEntity<PersonResponse>> findMap(@PathVariable final long id) {
        return this.service.findFull(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/find-api")
    public Mono<PersonResponse> findApi() {
        return this.service.findAPI();
    }

    @GetMapping("/flux")
    public Flux<Person> flux() {
        return this.service.listPeople();
    }
}
