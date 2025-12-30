package br.com.consultantfipetable.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

    @JsonProperty("Valor")
    private String value;
    @JsonProperty("Marca")
    private String brand;
    @JsonProperty("Modelo")
    private String model;
    @JsonProperty("AnoModelo")
    private String yearBrand;
    @JsonProperty("Combustivel")
    private String fuel;
    @JsonProperty("CodigoFipe")
    private String codeFipe;

    @Override
    public String toString() {
        return String.format("""
        Vehicle {
          codeFipe: '%s',
          fuel: '%s',
          yearBrand: '%s',
          model: '%s',
          brand: '%s',
          value: '%s'
        }""", codeFipe, fuel, yearBrand, model, brand, value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearBrand() {
        return yearBrand;
    }

    public void setYearBrand(String yearBrand) {
        this.yearBrand = yearBrand;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getCodeFipe() {
        return codeFipe;
    }

    public void setCodeFipe(String codeFipe) {
        this.codeFipe = codeFipe;
    }
}
