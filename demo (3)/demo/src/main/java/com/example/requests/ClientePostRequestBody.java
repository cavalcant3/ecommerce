package com.example.requests;

import lombok.Data;

@Data
public class ClientePostRequestBody {
    private String name;
    private String cpfCnpj;
}
