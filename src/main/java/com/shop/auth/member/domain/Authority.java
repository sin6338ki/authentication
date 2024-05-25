package com.shop.auth.member.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

public enum Authority {
    ROLE_USER, ROLE_ADMIN
}
