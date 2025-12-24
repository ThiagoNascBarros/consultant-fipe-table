package br.com.consultantfipetable.Domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleResponse(@JsonAlias("codigo") String code,
                              @JsonAlias("nome") String brand) {
}
