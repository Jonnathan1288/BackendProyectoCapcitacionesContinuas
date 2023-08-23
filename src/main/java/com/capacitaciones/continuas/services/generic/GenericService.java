package com.capacitaciones.continuas.services.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, ID extends Serializable> {
    public List<T> findByAll();

    public T save(T entity);

    public T findById(ID id);

    public void delete(ID id);

    public void deleteEntity(T entity);

    //ANOTHER METHODS
    public T update(ID id, T entity);
    public Page<T> findByAll(Pageable pageable);

}
