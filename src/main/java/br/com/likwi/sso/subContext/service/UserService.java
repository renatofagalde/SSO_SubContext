package br.com.likwi.sso.subContext.service;

import br.com.likwi.sso.subContext.entity.User;
import br.com.likwi.sso.subContext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        final User user = this.userRepository.findByUserName(username)
                .orElseThrow(IllegalArgumentException::new);

        return user;
    }
}
