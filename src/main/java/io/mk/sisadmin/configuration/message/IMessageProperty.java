package io.mk.sisadmin.configuration.message;

public interface IMessageProperty {
    String key();

    String message();

    IMessageProperty bind(String... args);
}
