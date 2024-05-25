package com.shop.auth.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.shop.auth.member.domain.Authority;
import com.shop.auth.member.domain.Member;
import com.shop.auth.member.domain.Password;
import com.shop.auth.member.domain.RefreshToken;
import com.shop.auth.member.repository.MemberRepository;
import java.text.ParseException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest //JPA Repository들에 대한 빈을 등록하여 단위 테스트의 작성을 용이하게 함
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository; //테스트이므로 @Autowired 사용

    @Test
    public void 회원등록() throws ParseException {
        //given
        LocalDateTime now = LocalDateTime.of(2024,5,25,18,22,10);

//        final RefreshToken refreshToken = new RefreshToken("RefreshTokenValue", now);
        final RefreshToken refreshToken = new RefreshToken("refreshTokenValue", now);

        final Member member = Member.builder()
                .email("test@example.com")
                .password(new Password("password"))
                .authority(Authority.ROLE_USER)
                .refreshToken(refreshToken)
                .build();

        //when
        final Member result = memberRepository.save(member);

        //then
        assertThat(result.getEmail()).isNotNull();
        assertThat(result.getEmail()).isEqualTo("test@example.com");
        assertThat(result.getPassword().equals(new Password("password"))).isTrue();
        assertThat(result.getAuthority()).isEqualTo(Authority.ROLE_USER);
        assertThat(
                result.getRefreshToken().equals(new RefreshToken("refreshTokenValue", now)))
                .isTrue();
    }

}
