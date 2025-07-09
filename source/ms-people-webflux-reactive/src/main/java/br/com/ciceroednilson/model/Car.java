package br.com.ciceroednilson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private String color;
    private long personId;
}
