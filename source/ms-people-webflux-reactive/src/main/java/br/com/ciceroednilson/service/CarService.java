package br.com.ciceroednilson.service;

import br.com.ciceroednilson.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarService {

    public Car find(final long personId) {
        log.info("Find car by person id {}", personId);
        return Car.builder()
                .make("Toyota")
                .model("Corolla")
                .year(2020)
                .licensePlate("ABC-1234")
                .color("Prata")
                .personId(personId)
                .build();
    }
}
