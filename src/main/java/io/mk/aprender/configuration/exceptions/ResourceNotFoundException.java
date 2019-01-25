package io.mk.aprender.configuration.exceptions;

import io.mk.aprender.configuration.message.IMessageProperty;

import java.util.Optional;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Optional<IMessageProperty> message = Optional.empty();

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(IMessageProperty message) {
        super(message.message());
        this.message = Optional.of(message);
    }

    public ResourceNotFoundException(IMessageProperty message, Throwable cause) {
        super(message.message(), cause);
        this.message = Optional.of(message);
    }

    public Optional<IMessageProperty> getMessageField() {
        return this.message;
    }
}