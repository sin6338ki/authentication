package com.shop.auth.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.shop.auth.member.domain.Authority;
import com.shop.auth.member.domain.Member;
import com.shop.auth.member.domain.Password;
import com.shop.auth.member.repository.MemberRepository;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Optional;
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
        final Member member = Member.builder()
                .email("test@example.com")
                .password(new Password("password"))
                .authority(Authority.ROLE_USER)
                .created(LocalDateTime.now())
                .build();

        //when
        final Member result = memberRepository.save(member);

        //then
        assertThat(result.getEmail()).isNotNull();
        assertThat(result.getEmail()).isEqualTo("test@example.com");
        assertThat(result.getPassword().equals(new Password("password"))).isTrue();
        assertThat(result.getAuthority()).isEqualTo(Authority.ROLE_USER);
    }

}
