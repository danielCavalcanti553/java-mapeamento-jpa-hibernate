package com.example.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula.domain.manytomany.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
