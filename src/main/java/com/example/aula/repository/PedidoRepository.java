package com.example.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula.domain.onetoone.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
