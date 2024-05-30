package com.shop.auth.member.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorResponseDto {

    DUPLICATED_EMAIL_RESISTER(HttpStatus.BAD_REQUEST, "Duplicated Email for registration");

    private final HttpStatus httpStatus;
    private final String message;

}
