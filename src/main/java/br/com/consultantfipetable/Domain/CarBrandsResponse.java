package br.com.consultantfipetable.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CarBrandsResponse(@JsonProperty("codigo") String code,
                                @JsonProperty("nome") String brand) {
}
