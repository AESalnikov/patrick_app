package ru.patrick.application.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.patrick.application.controller.response.PetShopFeedListResponse;
import ru.patrick.application.service.PetShopService;

@RestController
@RequestMapping("/api/petshop")
public class PetShopController {

    private PetShopService service;

    @Autowired
    public PetShopController(PetShopService service) {
        this.service = service;
    }

    @GetMapping("/applaws/all/stock")
    public ResponseEntity<PetShopFeedListResponse> getAllApplawsInStock() {
        PetShopFeedListResponse response = service.getAllApplawsInStock();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/organix/all/stock")
    public ResponseEntity<PetShopFeedListResponse> getAllOrganixInStock() {
        PetShopFeedListResponse response = service.getAllOrganixInStock();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
