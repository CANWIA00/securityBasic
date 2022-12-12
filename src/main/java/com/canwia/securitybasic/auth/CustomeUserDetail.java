package com.canwia.securitybasic.auth;

import com.canwia.securitybasic.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomeUserDetail implements UserDetails {

    private String name;
    private String password;
    private List<GrantedAuthority> roles;

    public CustomeUserDetail(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRol_name())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
