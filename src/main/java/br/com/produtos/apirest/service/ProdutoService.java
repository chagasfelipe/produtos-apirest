package br.com.produtos.apirest.service;


import br.com.produtos.apirest.model.ProdutoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ProdutoService {

    public ResponseEntity<List<ProdutoModel>> findAll();

    public ResponseEntity<ProdutoModel> findById(@PathVariable("id") long id);

    public ResponseEntity save(@RequestBody @Valid ProdutoModel produtoModel, BindingResult bindingResult);

    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid ProdutoModel produtoModel, BindingResult bindingResult);

    public ResponseEntity deleteById(@PathVariable("id") long id);
}
