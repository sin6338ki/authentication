package com.shop.auth.member.handler;

import com.shop.auth.member.api.dto.MemberErrorResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberExceptionHandler extends RuntimeException{

    private final MemberErrorResponseDto memberErrorResponse;

    @Builder
    public MemberExceptionHandler(MemberErrorResponseDto memberErrorResponse) {
        this.memberErrorResponse = memberErrorResponse;
    }
}
