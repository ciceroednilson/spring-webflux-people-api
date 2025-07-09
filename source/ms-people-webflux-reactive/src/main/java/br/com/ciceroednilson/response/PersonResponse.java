package br.com.ciceroednilson.response;

import br.com.ciceroednilson.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    private Person person;
}
