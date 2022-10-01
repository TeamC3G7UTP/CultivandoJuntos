package com.co.cultivemosjuntos.app.percistence.dao.Repository;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IPlantDao;
import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class PlantDaoImpl implements IPlantDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<PlantEntity> get(Long id) {
        return Optional.ofNullable(entityManager.find(PlantEntity.class, id));
    }

    @Override
    public List<PlantEntity> getAll() {
        Query query = entityManager.createQuery("SELECT u FROM PlantEntity u");
        return query.getResultList();
    }
}
