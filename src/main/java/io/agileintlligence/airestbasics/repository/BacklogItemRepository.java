package io.agileintlligence.airestbasics.repository;

import io.agileintlligence.airestbasics.model.BacklogItem;
import org.springframework.data.repository.CrudRepository;

public interface BacklogItemRepository extends CrudRepository<BacklogItem, Long> {


}
