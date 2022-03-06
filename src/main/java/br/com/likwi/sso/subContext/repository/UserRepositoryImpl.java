package br.com.likwi.sso.subContext.repository;

import br.com.likwi.sso.subContext.entity.User;
import br.com.likwi.sso.subContext.entity.User_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepositoryQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByUserName(String userName) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        final Root<User> userRoot = criteriaQuery.from(User.class);
        userRoot.fetch(User_.roles);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(userRoot.get(User_.userName), userName));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        final User singleResult = this.entityManager.createQuery(criteriaQuery).getSingleResult();
        return Optional.of(singleResult);
    }
}
