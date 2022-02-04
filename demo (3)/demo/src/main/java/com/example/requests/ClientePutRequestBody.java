package com.example.requests;

import lombok.Data;

@Data
public class ClientePutRequestBody {
    private Long id;
    private String name;
    private String cpfCnpj;
}
