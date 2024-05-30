package com.shop.auth.member.application;

import com.shop.auth.member.api.dto.AddMemberResponseDto;
import com.shop.auth.member.api.dto.MemberErrorResponseDto;
import com.shop.auth.member.domain.Member;
import com.shop.auth.member.handler.MemberExceptionHandler;
import com.shop.auth.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberManagementService {

    private final MemberRepository memberRepository;

    public AddMemberResponseDto addMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(duplicateMember -> {
                    throw new MemberExceptionHandler(MemberErrorResponseDto.DUPLICATED_EMAIL_RESISTER);
                });

        final Member addSucessMember = memberRepository.save(member);
        return AddMemberResponseDto.builder().email(addSucessMember.getEmail()).authority(addSucessMember.getAuthority()).build();
    }

}
