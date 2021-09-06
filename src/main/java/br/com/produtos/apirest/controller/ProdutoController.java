package br.com.produtos.apirest.controller;

import br.com.produtos.apirest.model.ProdutoModel;
import br.com.produtos.apirest.service.ProdutoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Este Método Retorna uma Lista de Produtos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Recebe a Lista de Produtos."),
            @ApiResponse(responseCode = "404",description = "Produtos não encontrados.")
    })
    public List<ProdutoModel> findAll(){

        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Este Método Retorna um Produto mediante fornecimento do ID existente no Banco de Dados.")
    public ResponseEntity<ProdutoModel> finalById(@PathVariable("id") long id){

        return produtoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Este Método Cria um Produto mediante fornecimento dos dados necessários.")
    public ProdutoModel create(@RequestBody @Valid ProdutoModel produtoModel){

        return produtoService.create(produtoModel);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Este Método atualiza dados de um Produto mediante fornecimento do ID existente no Banco de Dados.")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid ProdutoModel produtoModel){

        return produtoService.update(id,produtoModel);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Este Método Deleta um Produto mediante fornecimento do ID existente no Banco de Dados.")
    public ResponseEntity deleteById(@PathVariable("id") long id){

        return produtoService.deleteById(id);
    }

}
