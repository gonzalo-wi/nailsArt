package com.nailsbydeni.nails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nailsbydeni.nails.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
