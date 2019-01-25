package io.mk.sisadmin.configuration.message;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSource {
    private static final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    private static MessageSource INSTANCIA;

    private MessageSource() {
    }

    public static MessageSource get() {
        if (INSTANCIA == null) {
            INSTANCIA = new MessageSource();
        }

        return INSTANCIA;
    }

    public String message(String key) {
        return messageSource.getMessage(key, (Object[])null, Locale.getDefault());
    }

    public String message(String key, String... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }

    static {
        messageSource.setBasenames(new String[]{"properties/messages", "api/messages"});
        messageSource.setDefaultEncoding("UTF-8");
    }
}
