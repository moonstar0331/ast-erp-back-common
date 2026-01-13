package com.api.ast.commonservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    GROUP_CODE_SELECT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Group Code Select Error"),
    GROUP_CODE_CREATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Group Code Create Error"),
    GROUP_CODE_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Group Code Update Error");

    private HttpStatus status;
    private String message;
}
