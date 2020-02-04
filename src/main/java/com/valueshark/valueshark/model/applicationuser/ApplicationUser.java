package com.valueshark.valueshark.model.applicationuser;

import com.valueshark.valueshark.model.portfolio.PortfolioItem;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    String username;
    String password;
    String firstName;
    String lastName;
    String email;

    @OneToMany(mappedBy = "user")
    public List<PortfolioItem> portfolio;

    public ApplicationUser() {};
    public ApplicationUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
