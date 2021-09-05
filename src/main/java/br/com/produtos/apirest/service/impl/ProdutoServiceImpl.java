package br.com.produtos.apirest.service.impl;

import br.com.produtos.apirest.model.ProdutoModel;
import br.com.produtos.apirest.repository.ProdutoRepository;
import br.com.produtos.apirest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository   produtoRepository;

    @Override
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @Override
    public ResponseEntity<ProdutoModel> findById(long id) {

        ProdutoModel produto = produtoRepository.findById(id).get();
        return ResponseEntity.ok(produto);
    }

    @Override
    public ResponseEntity save(ProdutoModel produtoModel, BindingResult bindingResult) {

        if(!bindingResult.hasErrors()){

            produtoRepository.save(produtoModel);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(produtoModel.getId()).toUri();

            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public ResponseEntity update(long id, ProdutoModel produtoModel, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()){

            produtoModel.setId(id);
            produtoRepository.save(produtoModel);

            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity deleteById(long id) {

        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
