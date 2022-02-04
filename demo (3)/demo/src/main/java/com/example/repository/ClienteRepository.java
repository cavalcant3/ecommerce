package com.example.repository;

import com.example.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//conexão com banco de dados... query
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {


}
