package io.agileintlligence.airestbasics.web;

import io.agileintlligence.airestbasics.model.BacklogItem;
import io.agileintlligence.airestbasics.service.BacklogItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

//@Controller // returns view

@RestController //returns json or
//A controller class handles requests from the client, in this case http requests, and responds with data
@RequestMapping("/backlog")
//this annotation will map all http requests coming to that URI to this class and the methods inside of
public class BacklogController {

    private BacklogItemService backlogItemService;

    public BacklogController(BacklogItemService backlogItemService) {
        this.backlogItemService = backlogItemService;
    }

    @GetMapping
    public ResponseEntity getBacklog(){
        //return new ResponseEntity(backlogItemService.retrieveBacklog(), HttpStatus.OK);
        return ResponseEntity.ok(backlogItemService.retrieveBacklog());
    }

    /**
     * Find by id
     * Two Options
     * Query Parameter
     * Path Variable
     */

    //Request Parameter Sample:http://localhost:8080/backlog/item?id=<id>

    @GetMapping("/item")
    public ResponseEntity getBLWithReqParam(@RequestParam(value="id")Long reqParam){
        return ResponseEntity.ok(backlogItemService.retrieveById(reqParam));
    }

    //Path Variable Sample:http://localhost:8080/backlog/<PathVariable>/item

    @GetMapping("/{id}/item")
    public ResponseEntity getBLWithPathVar(@PathVariable Long id){
        return ResponseEntity.ok(backlogItemService.retrieveById(id));
    }

    @DeleteMapping("/{id}/item")
    public ResponseEntity deleteBLWithPathVar(@PathVariable Long id){
        backlogItemService.deleteBacklogItem(id);
        return ResponseEntity.ok("Backlog item with ID: "+id+" was deleted");
    }

    @PutMapping("/{id}/item")
    public ResponseEntity updateBL(@PathVariable Long id, @RequestBody BacklogItem item){
        return ResponseEntity.ok(backlogItemService.update(id,item));
    }

    @PostMapping
    public ResponseEntity saveNewBL(@RequestBody BacklogItem backlogItem){
        return ResponseEntity.ok().body(backlogItemService.save(backlogItem));
    }
}



