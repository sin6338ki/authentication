package com.shop.auth.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(insertable = false, updatable = false)
    private String email;

    @Embedded
    @Column
    private Password password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Embedded
    @Column
    private RefreshToken refreshToken;
}
