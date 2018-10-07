package com.tweet.hashtags.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

@Data
public final class ApplicationResponse {
    private Object data;
    private boolean success;
    private String errorMessage;
    private Object errors;
    private int httpStatus;

    public static ApplicationResponse success(final Object data) {
        final ApplicationResponse response = new ApplicationResponse();
        response.setData(data);
        response.setSuccess(true);
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }
    public static ApplicationResponse success() {
        final ApplicationResponse response = new ApplicationResponse();
        response.setSuccess(true);
        response.setHttpStatus(HttpStatus.OK.value());
        return response;
    }
    public static ApplicationResponse failure(final Throwable error) {
        return failure(error.getMessage(), HttpStatus.BAD_REQUEST);
    }
    public static ApplicationResponse failure(final Throwable error, final HttpStatus httpStatus) {
        return failure(error.getMessage(), httpStatus);
    }
    public static ApplicationResponse failure(final String error) {
        return failure(error, HttpStatus.BAD_REQUEST);
    }
    public static ApplicationResponse failure(final String error, final HttpStatus httpStatus) {
        final ApplicationResponse response = new ApplicationResponse();
        final String errorMessage = StringUtils.isEmpty(error) ? "Something went wrong! Please try again later." : error;
        response.setErrorMessage(errorMessage);
        response.setErrorMessage(error);
        response.setSuccess(false);
        response.setHttpStatus(httpStatus.value());
        return response;
    }
    public static ApplicationResponse failure(final String errorMessage, final Object errors) {
        final ApplicationResponse response = new ApplicationResponse();
        response.setErrorMessage(errorMessage);
        response.setSuccess(false);
        response.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        response.setErrors(errors);
        return response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
