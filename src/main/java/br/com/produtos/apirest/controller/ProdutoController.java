package br.com.produtos.apirest.controller;

import br.com.produtos.apirest.model.ProdutoModel;
import br.com.produtos.apirest.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @ApiOperation(value = "Este Método Retorna uma Lista de Produtos.")
    public List<ProdutoModel> findAll(){

        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Este Método Retorna um Produto mediante fornecimento do ID existente no Banco de Dados.")
    public ResponseEntity<ProdutoModel> finalById(@PathVariable("id") long id){

        return produtoService.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Este Método Cria um Produto mediante fornecimento dos dados necessários.")
    public ProdutoModel create(@RequestBody @Valid ProdutoModel produtoModel){

        return produtoService.create(produtoModel);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Este Método atualiza dados de um Produto mediante fornecimento do ID existente no Banco de Dados.")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid ProdutoModel produtoModel){

        return produtoService.update(id,produtoModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Este Método Deleta um Produto mediante fornecimento do ID existente no Banco de Dados.")
    public ResponseEntity deleteById(@PathVariable("id") long id){

        return produtoService.deleteById(id);
    }

}
