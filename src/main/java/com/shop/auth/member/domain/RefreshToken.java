package com.shop.auth.member.domain;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.NoArgsConstructor;


@Embeddable
@NoArgsConstructor
public class RefreshToken {
    String refreshToken;
    LocalDateTime expiration;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefreshToken that = (RefreshToken) o;
        return Objects.equals(refreshToken, that.refreshToken) && Objects.equals(
                expiration, that.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshToken, expiration);
    }

    public String toString() {
        return refreshToken + " : " + expiration;
    }

    public RefreshToken(String refreshToken, LocalDateTime expiration) {
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }
}
