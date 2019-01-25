package io.mk.aprender.configuration.exceptions;

import io.mk.aprender.configuration.message.IMessageProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private List<IMessageProperty> messages = new ArrayList();

    public BusinessException() {
    }

    public BusinessException(IMessageProperty message) {
        super(message.message());
        this.messages.add(message);
    }

    public BusinessException(IMessageProperty... messages) {
        super(Arrays.toString(messages));
        this.messages.addAll(Arrays.asList(messages));
    }

    public List<IMessageProperty> getMessages() {
        return this.messages;
    }
}