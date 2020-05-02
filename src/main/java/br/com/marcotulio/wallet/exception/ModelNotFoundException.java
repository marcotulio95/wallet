package br.com.marcotulio.wallet.exception;

import com.sun.javafx.binding.StringFormatter;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(Long id) {
        super( StringFormatter.format("Model with id: %s was not found", id).getValue());
    }
}
