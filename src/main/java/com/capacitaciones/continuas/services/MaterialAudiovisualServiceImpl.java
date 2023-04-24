package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.MaterialAudiovisual;
import com.capacitaciones.continuas.models.MaterialConvencional;
import com.capacitaciones.continuas.repositorys.MaterialAudiovisualRepository;
import com.capacitaciones.continuas.repositorys.MaterialConvencionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MaterialAudiovisualServiceImpl extends GenericServiceImpl<MaterialAudiovisual, Integer> implements MaterialAudiovisualService {

    @Autowired
    private MaterialAudiovisualRepository materialAudiovisualRepository;

    @Override
    public CrudRepository<MaterialAudiovisual, Integer> getDao() {
        return materialAudiovisualRepository;
    }
}
