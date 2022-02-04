package com.example.Service;

import com.example.Domain.Cliente;
import com.example.mapper.ClienteMapper;
import com.example.repository.ClienteRepository;
import com.example.requests.ClientePostRequestBody;
import com.example.requests.ClientePutRequestBody;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor

//logica de negocio
public class  ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    public Cliente findByIdOrThrowBadRequestException(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "CLiente Não encontrado"));

    }

    public Cliente save(ClientePostRequestBody clientePostRequestBody) {

        return clienteRepository.save(ClienteMapper.INSTANCE.toCliente(clientePostRequestBody));
    }

    public Cliente delete(long id) {
        clienteRepository.delete(findByIdOrThrowBadRequestException(id));
        return null;
    }

    public Cliente replace(ClientePutRequestBody clientePutRequestBody) {
        Cliente SavedCliente = findByIdOrThrowBadRequestException(clientePutRequestBody.getId());
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clientePutRequestBody);
        clientePutRequestBody.setId(SavedCliente.getId());
        clienteRepository.save(cliente);
        return null;
    }
}
