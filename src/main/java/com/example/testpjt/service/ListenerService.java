package com.example.testpjt.service;

import com.example.testpjt.data.entity.ListenerEntity;

public interface ListenerService {

    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listenerEntity);

    void updateEntity(ListenerEntity listenerEntity);

    void removeEntity(ListenerEntity listenerEntity);

}
