package note.note.security;

import note.note.entity.User;
import note.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SecurityUserDetail implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        User activeUser = userService.getUserByEmail(s);

        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(activeUser.getEmail(),"{noop}"+activeUser.getPassword(), Arrays.asList(authority));

        return userDetails;



    }
}
