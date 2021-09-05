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
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){

        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> finalById(@PathVariable("id") long id){

        return produtoService.findById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ProdutoModel produtoModel, BindingResult bindingResult){

        return produtoService.save(produtoModel, bindingResult);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid ProdutoModel produtoModel, BindingResult bindingResult){

        return produtoService.update(id,produtoModel,bindingResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){

        return produtoService.deleteById(id);
    }

}
