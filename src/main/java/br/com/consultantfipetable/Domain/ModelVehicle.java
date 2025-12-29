package br.com.consultantfipetable.Domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelVehicle(@JsonAlias("modelos") List<Data> models,
                           @JsonAlias("anos") List<Data> year) {
}
