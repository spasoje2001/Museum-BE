package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Curator;

public interface ICuratorService extends ICRUDService<Curator, Integer> {

    Curator update(Curator updated);

    Curator findByUsername(String username);

}
