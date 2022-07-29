package dio.spring.security.domain.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "tb_users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserDetails implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @OneToMany(mappedBy = "authUserDetails", fetch = FetchType.EAGER)
    private Set<AuthGrantedAuthority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
