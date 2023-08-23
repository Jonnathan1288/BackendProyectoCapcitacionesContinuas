package com.capacitaciones.continuas.services.generic;

import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImplv2<T, ID extends Serializable> implements GenericService<T, ID>{

    public abstract GenericRepository<T, ID> getDao();

    @Override
    public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(data -> list.add(data));
        return list;
    }

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        Optional<T> optionaE = getDao().findById(id);
        if(optionaE.isPresent()){
            T entityUpdate = optionaE.get();
            entityUpdate = getDao().save(entity);
            return getDao().save(entityUpdate);
        }
        return null;
    }

    @Override
    public Page<T> findByAll(Pageable pageable) {
        Page<T> list = getDao().findAll(pageable);
        return list;
    }

    @Override
    public T findById(ID id) {
        Optional<T> data = getDao().findById(id);
        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public void deleteEntity(T entity) {
        getDao().delete(entity);
    }
}
