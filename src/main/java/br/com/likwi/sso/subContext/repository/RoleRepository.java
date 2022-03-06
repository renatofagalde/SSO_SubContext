package br.com.likwi.sso.subContext.repository;

import br.com.likwi.sso.subContext.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
