package by.itechart.demo.security;

import by.itechart.demo.user.model.Role;
import by.itechart.demo.user.model.User;
import by.itechart.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServices implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    private static UserPrinciple build(User user) {
        List<Role> roles = user.getRole();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>() {{
            add(new SimpleGrantedAuthority(user.getRole().toString()));
        }};
        return new UserPrinciple(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                authorities

        );
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        User usr = userRepository.findByUserName(s).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return build(usr);
    }
}
