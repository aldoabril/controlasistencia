/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.repository;

import com.informaticadev.util.Criterio;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CARLOS
 * @param <Entity>
 * @param <KeyType>
 */
public interface BaseRepository<Entity, KeyType> {
    
    public Entity get(KeyType key);

    public void save(Entity entity);
    
    public Serializable saveAndReturnId(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);

    public void bulkDelete(List<Entity> entities);

    public List<Entity> getAll();
    
    public List<Entity> searchForCriteria(Criterio criterio);

    public Long countResultForCriteria(Criterio criterio);
}
