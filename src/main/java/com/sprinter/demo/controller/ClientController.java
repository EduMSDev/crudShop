package com.sprinter.demo.controller;

import com.sprinter.demo.model.Client;
import com.sprinter.demo.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/clients")
@RestController
@Slf4j
public class ClientController extends GenericController<Client, ClientService> {

    protected ClientController(ClientService repository) {
        super(repository);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Client> partialUpdateClient(@RequestParam @PathVariable Long id, @RequestBody Client category) {
        log.info("Actualizando parcialmente el cliente");
        this.genericService.partialUpdate(id, category);
        return ResponseEntity.ok(null);
    }

}
