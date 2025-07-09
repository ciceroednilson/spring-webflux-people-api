package br.com.ciceroednilson.service;

import br.com.ciceroednilson.model.Address;
import br.com.ciceroednilson.model.Car;
import br.com.ciceroednilson.model.Company;
import br.com.ciceroednilson.model.Person;
import br.com.ciceroednilson.model.Role;
import br.com.ciceroednilson.response.PersonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple5;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
public class ProcessService {

    private final PersonService personService;
    private final AddressService addressService;
    private final CarService carService;
    private final CompanyService companyService;
    private final RoleService roleService;
    private final WebClient webClient;

    @Value("${endpoint}")
    private String endpointPerson;

    public ProcessService(final PersonService personService,
                          final AddressService addressService,
                          final CarService carService,
                          final CompanyService companyService,
                          final RoleService roleService,
                          final WebClient webClient) {
        this.personService = personService;
        this.addressService = addressService;
        this.carService = carService;
        this.companyService = companyService;
        this.roleService = roleService;
        this.webClient = webClient;
    }

    public Mono<PersonResponse> findZip() {
        final long id = 1L;
        final Mono<Person> person = Mono.just(this.personService.find(id));
        final Mono<Address> address = Mono.just(this.addressService.find(id));
        final Mono<Car> car = Mono.just(this.carService.find(id));
        final Mono<Company> company = Mono.just(this.companyService.find(id));
        final Mono<Role> role = Mono.just(this.roleService.find(id));
        return Mono.zip(person, address, car, company, role).map(this::mapPerson);
    }

    private PersonResponse mapPerson(Tuple5<Person, Address, Car, Company, Role> objects) {
        final Person person = objects.getT1();
        person.setAddress(objects.getT2());
        person.setCar(objects.getT3());
        person.setCompany(objects.getT4());
        person.setRole(objects.getT5());
        return PersonResponse
                .builder()
                .person(person)
                .build();
    }

    public Mono<PersonResponse> findUsingJust(final long id) {
        if (id == BigInteger.ONE.longValue()) {
            final Person person = this.personService.find(id);
            return Mono.just(PersonResponse.builder().person(person).build());
        }
        return Mono.empty();
    }

    public Mono<PersonResponse> findFull(final long id) {
        if (id == BigInteger.ONE.longValue()) {
            return this.findZip();
        }
        return Mono.empty();
    }

    public Mono<PersonResponse> findAPI() {
        log.info("Finding in the API");
        return this.webClient.get()
                .uri(this.endpointPerson)
                .retrieve()
                .bodyToMono(PersonResponse.class);
    }

    public Flux<Person> listPeople() {
        return Flux.just(
                this.personService.find(1),
                this.personService.find(2),
                this.personService.find(3),
                this.personService.find(4));
    }
}
