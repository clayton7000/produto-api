/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.produto.produto.service;

import com.produto.produto.model.Produto;
import com.produto.produto.model.RespostaModelo;
import com.produto.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author clayt
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private RespostaModelo rm;

    public Iterable<Produto> listar() {
        return repository.findAll();
    }

    // Método para cadastrar produtos
    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao) {

        if (produto.getNome().equals("")) {
            rm.setMensagem("0 nome do produto é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (produto.getMarca()
                .equals("")) {
            rm.setMensagem("0 nome da marca é obrigatério!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<Produto>(repository.save(produto), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Produto>(repository.save(produto), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(long codigo) {
        repository.deleteById(codigo);
        rm.setMensagem("0 produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
}

}
