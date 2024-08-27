package com.veljko121.backend.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.veljko121.backend.core.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String username;
    
    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    
    @NotEmpty
    @Column(nullable = false)
    private String password;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;

    @NotEmpty
    private String picture;
    
    @Enumerated
    private Role role;

    @Column(nullable = false)
    private Boolean isAccountLocked = false;

    @OneToMany(mappedBy = "user", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true, fetch = jakarta.persistence.FetchType.EAGER)
    private List<Notification> notifications = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
        notification.setUser(this);
    }

    public void removeNotification(Notification notification) {
        notifications.remove(notification);
        notification.setUser(null);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
