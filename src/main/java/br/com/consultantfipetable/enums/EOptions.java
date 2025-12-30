package br.com.consultantfipetable.enums;

public enum EOptions {
    CARS("cars"),
    TRUCKS("trucks"),
    MOTORCYCLES("motorcycles");

    private final String value;

    EOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
