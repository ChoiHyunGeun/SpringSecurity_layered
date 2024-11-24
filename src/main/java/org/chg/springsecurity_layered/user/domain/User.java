package org.chg.springsecurity_layered.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Table(name = "USER")
@ToString
@Setter
@Getter
@Entity
public class User {
    @Id
    @Column(name = "USER_ID")
    String userId;

    @Column(name = "PASSWORD")
    String password;

    public User() {}

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
