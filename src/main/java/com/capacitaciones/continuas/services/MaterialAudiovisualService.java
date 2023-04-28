package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.MaterialAudiovisual;

import java.util.List;

public interface MaterialAudiovisualService extends  GenericService<MaterialAudiovisual, Integer>{

    List<MaterialAudiovisual> findBySilaboIdSilabo(Integer idSilabo);
}
