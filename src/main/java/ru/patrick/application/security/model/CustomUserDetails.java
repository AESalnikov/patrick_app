package ru.patrick.application.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.patrick.application.entity.ApplicationUser;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ru.patrick.application.entity.Status.ACTIVE;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
    private boolean isActive;

    public static UserDetails fromApplicationUser(ApplicationUser user) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.username = user.getLogin();
        customUserDetails.password = user.getPassword();
        customUserDetails.authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        customUserDetails.isActive = user.getStatus().equals(ACTIVE) ? true : false;
        return customUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}
