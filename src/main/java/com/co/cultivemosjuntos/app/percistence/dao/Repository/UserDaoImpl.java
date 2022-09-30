package com.co.cultivemosjuntos.app.percistence.dao.Repository;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IUserDao;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Repository
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<UserEntity> get(Long id) {
        return Optional.ofNullable(entityManager.find(UserEntity.class, id));
    }

    @Override
    public List<UserEntity> getAll() {
        Query query = entityManager.createQuery("SELECT u FROM UserEntity u");
        return query.getResultList();
    }

    @Override
    public void save(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public boolean update(UserEntity userEntity) {
        var response = entityManager.merge(userEntity);
        return response != null;
    }

    @Override
    public void delete(UserEntity userEntity) {
        executeInsideTransaction(entityManager -> entityManager.remove(userEntity));
    }

    @Override
    @Transactional
    public boolean existsUserByUsername(String username) {
        return getAll()
                .stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    @Transactional
    public UserEntity getUserByUsername(String username) {
        return getAll()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            /* tx.commit();*/
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
