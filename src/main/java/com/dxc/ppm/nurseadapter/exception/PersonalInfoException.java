package com.dxc.ppm.nurseadapter.exception;


import com.dxc.ppm.nurseadapter.common.PersonalInfoStorageError;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PersonalInfoException extends RuntimeException {
    private final PersonalInfoStorageError response;

    PersonalInfoException(PersonalInfoStorageError response) {
        this(response, null, new Object[0]);
    }

    PersonalInfoException(PersonalInfoStorageError response, Throwable cause, Object... params) {
        super(response + Arrays.stream(params).map(Object::toString).collect(Collectors.joining(";", "{", "}")));
        this.response = response;
    }

    PersonalInfoException(PersonalInfoStorageError response, Object... params) {
        this(response, null, params);
    }

    public PersonalInfoStorageError getResponse() {
        return response;
    }
}