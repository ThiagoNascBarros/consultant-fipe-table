package br.com.consultantfipetable.domain;

public class DataClass {

    private Integer code;
    private String brand;

    public DataClass(String code, String brand) {
        this.code = Integer.parseInt(code);
        this.brand = brand;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Code: " + code + " Brand: " + brand;
    }

}
