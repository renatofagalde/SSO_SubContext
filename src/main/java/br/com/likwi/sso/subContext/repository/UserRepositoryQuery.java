package br.com.likwi.sso.subContext.repository;

import br.com.likwi.sso.subContext.entity.User;

import java.util.Optional;


public interface UserRepositoryQuery {

    Optional<User> findByUserName(String userName);

}
