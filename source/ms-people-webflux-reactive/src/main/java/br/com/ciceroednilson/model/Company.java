package br.com.ciceroednilson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private long id;
    private String name;
    private String cnpj;
    private String industry;
    private String email;
    private String phone;
    private Address address;
    private long personId;
}
