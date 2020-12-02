package com.exchanger.model;

import com.exchanger.model.enumeration.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
