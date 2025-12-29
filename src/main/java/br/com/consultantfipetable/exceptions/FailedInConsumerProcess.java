package br.com.consultantfipetable.exceptions;

public class FailedInConsumerProcess extends RuntimeException {
    public FailedInConsumerProcess(String message) {
        super(message);
    }
}
