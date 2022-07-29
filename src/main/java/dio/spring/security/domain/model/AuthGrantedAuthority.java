package dio.spring.security.domain.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "tb_authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthGrantedAuthority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUserDetails authUserDetails;
}
