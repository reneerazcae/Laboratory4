package com.example.busreservation.securityconfiguration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public final class InMemoryUserDetailsManager implements UserDetailsService {
    private final UserDetails admin;
    private final UserDetails staff;
    private final UserDetails client;

    public InMemoryUserDetailsManager(UserDetails admin, UserDetails staff,
                                      UserDetails client) {
        this.admin = admin;
        this.staff = staff;
        this.client = client;
    }

    public UserDetails admin() {
        return admin;
    }

    public UserDetails staff() {
        return staff;
    }

    public UserDetails client() {
        return client;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (InMemoryUserDetailsManager) obj;
        return Objects.equals(this.admin, that.admin) &&
                Objects.equals(this.staff, that.staff) &&
                Objects.equals(this.client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admin, staff, client);
    }

    @Override
    public String toString() {
        return "InMemoryUserDetailsManager[" +
                "admin=" + admin + ", " +
                "staff=" + staff + ", " +
                "client=" + client + ']';
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
