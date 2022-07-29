package dio.spring.security.domain.repository;

import dio.spring.security.domain.model.AuthUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserDetailsRepository extends JpaRepository<AuthUserDetails, Long> {
    Optional<AuthUserDetails> findByUsername(String username);
}
