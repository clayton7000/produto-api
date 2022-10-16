/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.produto.produto.controller;

import com.produto.produto.model.Produto;
import com.produto.produto.model.RespostaModelo;
import com.produto.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author clayt
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/listar")
    public Iterable<Produto> listar() {
        return service.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
        return service.cadastrarAlterar(produto, "cadastrar");
    }

    @PutMapping("alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto) {
        return service.cadastrarAlterar(produto, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {
        return service.remover(codigo);
    }

    @GetMapping("/")
    public String rota() {
        return "API de produtos funciomamdo!";
    }

}
