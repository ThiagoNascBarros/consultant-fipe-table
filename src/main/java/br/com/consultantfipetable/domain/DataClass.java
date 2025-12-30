package br.com.consultantfipetable.domain;

public class DataClass {

    private Integer code;
    private String brand;

    public DataClass(Integer code, String brand) {
        this.code = code;
        this.brand = brand;
    }

    public DataClass(String code, String brand) {
        this.code = Integer.parseInt(code);
        this.brand = brand;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Code: " + code + " Brand: " + brand;
    }

}
