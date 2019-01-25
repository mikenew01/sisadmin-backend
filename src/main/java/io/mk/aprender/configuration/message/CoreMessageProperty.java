package io.mk.aprender.configuration.message;


public enum CoreMessageProperty implements IMessageProperty {
    API_ACCESS_DENIED("api.access-denied"),
    API_UNDENTIFIED_ERROR("api.unidentified-error"),
    API_RESOURCE_NOTFOUND("api.resource-notfound"),
    API_DYNAMIC_QUERY_PAGEBLE_REQUIRED("api.dynamicquery.pageable.required"),
    API_DYNAMIC_QUERY_PARAMETERS_REQUIRED("api.dynamicquery.parameters.required"),
    API_DYNAMIC_QUERY_INVALID_RESULT_CLASS("api.dynamicquery.invalid.resultclass"),
    API_DYNAMIC_QUERY_RESOURCE_NOTFOUND("api.dynamicquery.resource.notfound");

    private String key;
    private String[] args = new String[0];

    private CoreMessageProperty(String key) {
        this.key = key;
    }

    public String key() {
        return this.key;
    }

    public String message() {
        return this.args.length == 0 ? MessageSource.get().message(this.key) : MessageSource.get().message(this.key, this.args);
    }

    public IMessageProperty bind(String... args) {
        this.args = args;
        return this;
    }
}
