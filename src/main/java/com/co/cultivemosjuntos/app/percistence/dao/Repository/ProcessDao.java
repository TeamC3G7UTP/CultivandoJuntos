package com.co.cultivemosjuntos.app.percistence.dao.Repository;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IProcessDao;
import com.co.cultivemosjuntos.app.percistence.models.Entities.ProcessEntity;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProcessDao implements IProcessDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ProcessEntity processEntity) {
        entityManager.persist(processEntity);
    }

    @Override
    public boolean update(ProcessEntity processEntity) {
        var response = entityManager.merge(processEntity);
        return response != null;
    }

    @Override
    public void delete(ProcessEntity processEntity) {
        entityManager.remove(processEntity);
    }

    @Override
    public Optional<ProcessEntity> get(Long id) {
        return Optional.ofNullable(entityManager.find(ProcessEntity.class, id));
    }

    @Override
    public List<ProcessEntity> getAll() {
        Query query = entityManager.createQuery("SELECT u FROM ProcessEntity u");
        return query.getResultList();
    }

    @Override
    public List<ProcessEntity> processesForUser(Long userId) {
        return getAll().
                stream()
                .filter(x -> Objects.equals(x.getUser().getId(), userId))
                .collect(Collectors.toList());

    }

    @Override
    public boolean validateAssignmentProcesses(Long userId, Long plantId) {
        return getAll()
                .parallelStream()
                .anyMatch(x ->
                        !(x.getUser().getId().equals(userId)
                                && x.getPlant().getId().equals(plantId)
                                && !x.isFinalized()));
    }
}
