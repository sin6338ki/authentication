package com.shop.auth.member.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.auth.member.api.dto.AddMemberResponseDto;
import com.shop.auth.member.api.dto.MemberErrorResponseDto;
import com.shop.auth.member.domain.Authority;
import com.shop.auth.member.domain.Member;
import com.shop.auth.member.domain.Password;
import com.shop.auth.member.handler.MemberExceptionHandler;
import com.shop.auth.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MemberManagementServiceTest {

    @InjectMocks //테스트 대상
    private MemberManagementService memberManagementService;
    @Mock //가짜 객체 생성
    private MemberRepository memberRepository;

    private final Member member = Member.builder()
            .email("test@test.com")
            .password(Password.builder().password("password").build())
            .authority(Authority.ROLE_USER)
            .created(LocalDateTime.now())
            .build();

    @Test
    public void 멤버등록실패_이미존재하는이메일(){
        //given
        when(memberRepository.findByEmail("test@test.com")).thenReturn(Optional.ofNullable(member));

        //when
        final MemberExceptionHandler result = assertThrows(MemberExceptionHandler.class, () -> memberManagementService.addMember(member));

        //then
        assertThat(result.getMemberErrorResponse()).isEqualTo(MemberErrorResponseDto.DUPLICATED_EMAIL_RESISTER);
    }

    @Test
    public void 멤버십등록성공(){
        //given
        when(memberRepository.findByEmail("test@test.com")).thenReturn(Optional.empty());
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        //when
        final AddMemberResponseDto addSucessMember = memberManagementService.addMember(member);

        //then
        assertThat(addSucessMember.getEmail()).isNotNull();
        assertThat(addSucessMember.getAuthority()).isEqualTo(Authority.ROLE_USER);

        //verify
        verify(memberRepository, times(1)).findByEmail("test@test.com");
        verify(memberRepository, times(1)).save(any(Member.class));

    }

}
