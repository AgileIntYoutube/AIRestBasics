package io.agileintlligence.airestbasics.service;

import io.agileintlligence.airestbasics.model.BacklogItem;

import java.util.List;
import java.util.Optional;

public interface BacklogItemService {

    //CRUDL

    Iterable<BacklogItem> retrieveBacklog();
    BacklogItem retrieveById(Long id);
    BacklogItem save(BacklogItem backlogItem);
    BacklogItem update(Long id, BacklogItem item);
    void deleteBacklogItem(Long id);

}
