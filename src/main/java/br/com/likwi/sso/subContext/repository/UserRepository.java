package br.com.likwi.sso.subContext.repository;

import br.com.likwi.sso.subContext.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>,UserRepositoryQuery{

}
