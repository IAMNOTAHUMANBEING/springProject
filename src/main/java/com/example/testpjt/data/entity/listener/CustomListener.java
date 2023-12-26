package com.example.testpjt.data.entity.listener;

import com.example.testpjt.data.entity.ListenerEntity;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomListener {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @PostLoad
    public void postLoad(ListenerEntity listenerEntity) {
        LOGGER.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(ListenerEntity listenerentity) {
        LOGGER.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(ListenerEntity listenerentity) {
        LOGGER.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity listenerentity) {
        LOGGER.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity listenerentity) {
        LOGGER.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(ListenerEntity listenerentity) {
        LOGGER.info("[preRemove] called!!");
    }

    @PostRemove
    public void postRemove(ListenerEntity listenerentity) {
        LOGGER.info("[postRemove] called!!");
    }
}