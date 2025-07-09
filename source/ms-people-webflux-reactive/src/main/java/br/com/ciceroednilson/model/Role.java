package br.com.ciceroednilson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private long personId;
    private String name;
    private String description;
    private String level;
}
