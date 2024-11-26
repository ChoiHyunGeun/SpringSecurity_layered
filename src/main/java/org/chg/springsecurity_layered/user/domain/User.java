package org.chg.springsecurity_layered.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.chg.springsecurity_layered.user.presentation.UserResponseCommand;

@Builder
@Table(name = "USER")
@ToString
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    int seq;

    @Column(name = "USER_ID")
    String username;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "USER_ROLE")
    String userRole;

    public User() {}

    public User(int seq, String username, String password, String userRole) {
        this.seq = seq;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public UserResponseCommand toCommand() {
        return UserResponseCommand.builder()
                .seq(this.seq)
                .userId(this.username)
                .userRole(this.userRole)
                .build();
    }
}
