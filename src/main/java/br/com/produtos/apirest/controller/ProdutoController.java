package br.com.produtos.apirest.controller;

import br.com.produtos.apirest.model.ProdutoModel;
import br.com.produtos.apirest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> findAll(){

        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> finalById(@PathVariable("id") long id){

        return produtoService.findById(id);
    }

    @PostMapping
    public ProdutoModel create(@RequestBody @Valid ProdutoModel produtoModel){

        return produtoService.create(produtoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid ProdutoModel produtoModel){

        return produtoService.update(id,produtoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){

        return produtoService.deleteById(id);
    }

}
