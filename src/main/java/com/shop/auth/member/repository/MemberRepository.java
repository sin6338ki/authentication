package com.shop.auth.member.repository;

import com.shop.auth.member.domain.Member;
import com.shop.auth.member.domain.Password;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
