package com.example.controller;

import com.example.Domain.Cliente;
import com.example.Service.ClienteService;
import com.example.requests.ClientePostRequestBody;
import com.example.requests.ClientePutRequestBody;
import com.example.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// endpoints
@RestController
@RequestMapping("ecommerce")
@Log4j2
@RequiredArgsConstructor
public class ClienteController {


    private final ClienteService clienteService;


    @GetMapping(path = "clients")
    public ResponseEntity<List<Cliente>> list() {
        return new ResponseEntity<>(clienteService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "clients/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
    }

//    insert return type
    @GetMapping(path = "clients/{id}/type")
    public ResponseEntity<Cliente> insert(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody clientePostRequestBody) {
        return ResponseEntity.ok(clienteService.save(clientePostRequestBody));
    }
    @DeleteMapping(path = "clients/{id}")
    public Cliente delete(@PathVariable long id){
        return clienteService.delete(id);
    }

    @PutMapping
    public Cliente replace(@RequestBody ClientePutRequestBody clientePutRequestBody) {
        return clienteService.replace(clientePutRequestBody);
    }
}
