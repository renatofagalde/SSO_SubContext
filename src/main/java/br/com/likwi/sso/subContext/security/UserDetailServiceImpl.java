package br.com.likwi.sso.subContext.security;

import br.com.likwi.sso.subContext.entity.User;
import br.com.likwi.sso.subContext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = this.userService.getUserByUsername(username);
        final org.springframework.security.core.userdetails.User userAuthenticated = new org.springframework.security.core.userdetails
                .User(username, user.getPassword(), setRoles(user));
        return userAuthenticated;

    }
    private Collection<? extends GrantedAuthority> setRoles(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return authorities;
    }

}
