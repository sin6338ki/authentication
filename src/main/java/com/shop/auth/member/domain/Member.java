package com.shop.auth.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(insertable = false, updatable = false)
    private String email;

    @Embedded
    @Column
    private Password password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column
    private LocalDateTime created;

    @Builder
    public Member(String email, Password password, Authority authority, LocalDateTime created) {
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.created = created;
    }

    @Builder
    public Member(String email, Password password) {
        this.email = email;
        this.password = password;
    }

}
