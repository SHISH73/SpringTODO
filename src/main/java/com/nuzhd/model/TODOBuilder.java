package com.nuzhd.model;

public class TODOBuilder {
    private static TODOBuilder instance = new TODOBuilder();
    private String id = null;
    private String description = "";

    private TODOBuilder() {
    }

    public static TODOBuilder create(){
        return instance;
    }

    public TODOBuilder withDescription(String description) {
        this.description = description;
        return instance;
    }

    public TODOBuilder withID(String id) {
        this.id = id;
        return instance;
    }

    public TODO build() {
        TODO result = new TODO(this.description);
        if (id != null) {
            result.setId(id);
        }
        return result;

    }
}
