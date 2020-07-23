package com.agrongemajli.twitclone.services;

import com.agrongemajli.twitclone.models.AuthUser;
import com.agrongemajli.twitclone.models.SpringUser;
import com.agrongemajli.twitclone.models.User;
import com.agrongemajli.twitclone.repositories.AuthRepository;
import com.agrongemajli.twitclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AuthUser authUser = authRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + userName + " not found"));
        User user = userRepository.findUserByAuthData_AuthID(authUser.getAuthID()).orElse(null);

        if(user != null){
            return new SpringUser(authUser.getUsername(), authUser.getPassword(), getAuthorities(authUser), user.getUserID(), user.getFullName());
        } else {
            return new SpringUser(authUser.getUsername(), authUser.getPassword(), getAuthorities(authUser));
        }

    }

    private static Collection<GrantedAuthority> getAuthorities(AuthUser user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
