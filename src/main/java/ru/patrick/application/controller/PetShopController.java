package ru.patrick.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.patrick.application.controller.response.FeedListResponse;
import ru.patrick.application.service.PetStoreService;

@RestController
@RequestMapping("/api/petshop")
public class PetShopController {

    private final PetStoreService service;

    @Autowired
    public PetShopController(@Qualifier("petShopService") PetStoreService service) {
        this.service = service;
    }

    @GetMapping("/applaws/all/stock")
    public ResponseEntity<FeedListResponse> getAllApplawsInStock() {
        FeedListResponse response = service.getAllApplawsInStock();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/organix/all/stock")
    public ResponseEntity<FeedListResponse> getAllOrganixInStock() {
        FeedListResponse response = service.getAllOrganixInStock();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
