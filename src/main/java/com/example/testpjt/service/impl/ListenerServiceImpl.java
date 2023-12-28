package com.example.testpjt.service.impl;

import com.example.testpjt.data.entity.ListenerEntity;
import com.example.testpjt.data.repository.ListenerRepository;
import com.example.testpjt.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {

    private ListenerRepository listenerRepository;

    @Autowired
    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    // findById는 repository에서 추상메서드를 선언한게 아니므로 반환값 Optional이라서 get() 필요 
    @Override
    public ListenerEntity getEntity(Long id) { return listenerRepository.findById(id).get();}

    @Override
    public void saveEntity(ListenerEntity listenerEntity) {
        listenerRepository.save(listenerEntity);
    }

    @Override
    public void updateEntity(ListenerEntity listenerEntity) {
        ListenerEntity foundListener = listenerRepository.findById(listenerEntity.getId()).get();
        foundListener.setName(listenerEntity.getName());

        listenerRepository.save(foundListener);
    }

    @Override
    public void removeEntity(ListenerEntity listenerEntity) {
        listenerRepository.delete(listenerEntity);
    }
}
