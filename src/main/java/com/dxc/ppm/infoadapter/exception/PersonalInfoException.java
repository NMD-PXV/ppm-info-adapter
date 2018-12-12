package com.dxc.ppm.infoadapter.exception;


import com.dxc.ppm.infoadapter.common.PersonalInfoStorageError;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PersonalInfoException extends RuntimeException {
    private final PersonalInfoStorageError response;

    public PersonalInfoException(PersonalInfoStorageError response) {
        this(response, null, new Object[0]);
    }

    public PersonalInfoException(PersonalInfoStorageError response, Throwable cause, Object... params) {
        super(response + Arrays.stream(params).map(Object::toString).collect(Collectors.joining(";", "{", "}")));
        this.response = response;
    }

    public PersonalInfoException(PersonalInfoStorageError response, Object... params) {
        this(response, null, params);
    }

    public PersonalInfoStorageError getResponse() {
        return response;
    }
}