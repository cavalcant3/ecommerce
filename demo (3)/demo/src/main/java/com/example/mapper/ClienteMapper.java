package com.example.mapper;

import com.example.Domain.Cliente;
import com.example.requests.ClientePostRequestBody;
import com.example.requests.ClientePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public abstract Cliente toCliente(ClientePostRequestBody clientePostRequestBody);

    public abstract Cliente toCliente(ClientePutRequestBody clientePutRequestBody);


}
