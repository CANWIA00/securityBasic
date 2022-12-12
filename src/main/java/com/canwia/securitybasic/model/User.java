package com.canwia.securitybasic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "user_id")}
    ,inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")})
    private List<Role> roles;
}
