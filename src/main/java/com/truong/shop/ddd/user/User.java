package com.truong.shop.ddd.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "username",length = 100)
    private String username;
    @Column(name="password")
    private String password;
    private long phoneNumber;
    private String address;
    @ManyToMany
    @JoinTable(name = "UsersRoles",
            joinColumns =@JoinColumn(name = "usersId"),
            inverseJoinColumns = @JoinColumn(name = "rolesId")
            )
    private List<Role> roles;
}
