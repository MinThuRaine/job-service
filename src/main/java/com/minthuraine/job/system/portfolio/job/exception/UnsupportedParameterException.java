package com.minthuraine.job.system.portfolio.job.exception;

import java.util.List;


public class UnsupportedParameterException extends RuntimeException {

    private final List<String> unsupportedParameters;

    public UnsupportedParameterException(final List<String> unsupportedParameters) {
        this.unsupportedParameters = unsupportedParameters;
    }

    public List<String> getUnsupportedParameters() {
        return this.unsupportedParameters;
    }
}