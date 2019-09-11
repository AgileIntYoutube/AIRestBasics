package io.agileintlligence.airestbasics.service;

import io.agileintlligence.airestbasics.exception.BacklogItemNotFoundException;
import io.agileintlligence.airestbasics.model.BacklogItem;
import io.agileintlligence.airestbasics.repository.BacklogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BacklogItemServiceImpl implements BacklogItemService {


    private BacklogItemRepository backlogItemRepository;

    public BacklogItemServiceImpl(BacklogItemRepository backlogItemRepository) {
        this.backlogItemRepository = backlogItemRepository;
    }

    @Override
    public Iterable<BacklogItem> retrieveBacklog() {
        return backlogItemRepository.findAll();
    }

    @Override
    public BacklogItem retrieveById(Long id) {
        //Handle Exception if BL not found
        return backlogItemRepository.findById(id).orElseThrow(()->new BacklogItemNotFoundException("Backlog Item Not found"));
    }

    @Override
    public BacklogItem save(BacklogItem backlogItem) {
        return backlogItemRepository.save(backlogItem);
    }

    @Override
    public BacklogItem update(Long id, BacklogItem item) {
        //Handle Exception if BL not found
        return null;
    }

    @Override
    public void deleteBacklogItem(Long id) {
        BacklogItem item = backlogItemRepository.findById(id).orElseThrow(()->new BacklogItemNotFoundException("Backlog Item Not found"));
        backlogItemRepository.delete(item);
    }
}
