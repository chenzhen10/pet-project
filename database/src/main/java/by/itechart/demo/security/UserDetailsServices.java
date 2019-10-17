package by.itechart.demo.security;

import by.itechart.demo.user.model.User;
import by.itechart.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServices implements UserDetailsService {

    //user repository
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User usr = userRepository.findByUserName(s);
        return build(usr);
    }


    private static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>() {{
            add(new SimpleGrantedAuthority(user.getRole()));
        }};
        return new UserPrinciple(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                authorities

        );
    }
}
