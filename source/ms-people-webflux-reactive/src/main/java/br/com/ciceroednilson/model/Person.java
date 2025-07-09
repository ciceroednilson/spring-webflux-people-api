package br.com.ciceroednilson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Address address;
    private Company company;
    private Role role;
    private Car car;
}
