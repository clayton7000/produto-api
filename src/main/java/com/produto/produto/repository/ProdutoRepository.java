/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.produto.produto.repository;

import com.produto.produto.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author clayt
 */
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    
}
