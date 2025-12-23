package br.com.consultantfipetable.Domain;

public class Car {
    private int code;
    private String brand;

    public Car(int code, String brand) {
        this.code = code;
        this.brand = brand;
    }

    public Car(String code, String brand) {
        this.code = Integer.parseInt(String.valueOf(code));
        this.brand = brand;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
        return "\nCode: " + code + " Brand: " + brand;
    }
}
