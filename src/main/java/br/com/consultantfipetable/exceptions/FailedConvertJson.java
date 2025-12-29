package br.com.consultantfipetable.exceptions;

public class FailedConvertJson extends RuntimeException {
    public FailedConvertJson(String message) {
        super(message);
    }
}
