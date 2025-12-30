package br.com.consultantfipetable.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(@JsonAlias("codigo") String code,
                   @JsonAlias("nome") String brand) {

    @Override
    public String toString() {
        return "Code: " + code + " Brand: " + brand;
    }

}
