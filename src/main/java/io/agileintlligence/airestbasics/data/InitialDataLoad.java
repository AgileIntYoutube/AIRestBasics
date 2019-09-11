package io.agileintlligence.airestbasics.data;

import io.agileintlligence.airestbasics.model.BacklogItem;
import io.agileintlligence.airestbasics.repository.BacklogItemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//This loads the same data every time the application is started
//If you connect to MySQL or any other relational database in your environment
//Make sure that you comment this code out! or else it will load duplicate data over and over!

@Configuration
public class InitialDataLoad {

    private static final Logger logger = LogManager.getLogger(InitialDataLoad.class);

    @Bean
    CommandLineRunner LoadDB(BacklogItemRepository backlogItemRepository){
        return args -> {
            backlogItemRepository.save(new BacklogItem("Technical Task","Create Data Load", "Implement the CommandLineRunner interface","DONE"));
            backlogItemRepository.save(new BacklogItem("Technical Task","Create BacklogItemRepository", "Implement the CrudRepository interface","DONE"));
            backlogItemRepository.save(new BacklogItem("Technical Task","Create BacklogItemService", "Implement the Business Logic Service interface","TODO"));
            backlogItemRepository.save(new BacklogItem("Technical Task","Create CRUD routes in BacklogItemController", "Implement GET, POST, PUT, DELETE","TODO"));
            logger.info("DATA LOAD PERSISTED FROM CLASS - InitialDataLoad");
            logger.warn("DISABLE IF USING A IN DISK DATA STORE");
        };
    }
}
