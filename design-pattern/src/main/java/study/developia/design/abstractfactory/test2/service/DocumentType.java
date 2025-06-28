package study.developia.design.abstractfactory.test2.service;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DocumentType {
    PDF,
    WORD;

    @JsonCreator
    public static DocumentType fromString(String value) {
        return DocumentType.valueOf(value.toUpperCase());
    }

}
