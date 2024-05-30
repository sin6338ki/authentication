package com.shop.auth.member.api.dto;

import com.shop.auth.member.domain.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddMemberResponseDto {

    private String email;
    private Authority authority;

    @Builder
    public AddMemberResponseDto(String email, Authority authority) {
        this.email = email;
        this.authority = authority;
    }
}
