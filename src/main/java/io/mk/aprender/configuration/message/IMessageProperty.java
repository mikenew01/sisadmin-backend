package io.mk.aprender.configuration.message;

public interface IMessageProperty {
    String key();

    String message();

    IMessageProperty bind(String... args);
}
