package dio.spring.security.domain.service;

import dio.spring.security.domain.model.AuthUserDetails;
import dio.spring.security.domain.repository.AuthUserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username " + username));
    }

    public void createUser(UserDetails user) {
        repository.save((AuthUserDetails) user);
    }

    public void updateUser(UserDetails user) {
        repository.save((AuthUserDetails) user);
    }

    public void deleteUser(String username) {
        AuthUserDetails userDetails = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username " + username));
        repository.delete(userDetails);
    }

    public boolean userExists(String username) {
        return repository.findByUsername(username).isPresent();
    }
}
