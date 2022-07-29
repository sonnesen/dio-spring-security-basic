package dio.spring.security.domain.repository;

import dio.spring.security.domain.model.AuthGrantedAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGrantedAuthorityRepository extends JpaRepository<AuthGrantedAuthority, Long> {
}
