package br.com.consultantfipetable.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nonnull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(@JsonAlias("codigo") String code,
                   @JsonAlias("nome") String brand) {

    @Override
    @Nonnull
    public String toString() {
        return "Code: " + code + " Brand: " + brand;
    }

}
