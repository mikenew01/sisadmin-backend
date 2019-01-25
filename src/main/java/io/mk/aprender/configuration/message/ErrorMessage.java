package io.mk.aprender.configuration.message;

public class ErrorMessage {
    private String error;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(IMessageProperty messageProperty) {
        this.error = messageProperty.key();
        this.message = messageProperty.message();
    }

    public ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
