package com.shop.auth.member.domain;

import jakarta.persistence.Embeddable;
import java.util.Objects;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Password {
    String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Password password1 = (Password) o;
        return Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    public String toString(){
        return String.valueOf(password);
    }

    public Password(String password) {
        this.password = password;
    }
}
