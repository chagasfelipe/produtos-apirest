package br.com.produtos.apirest.service.impl;

import br.com.produtos.apirest.model.ProdutoModel;
import br.com.produtos.apirest.repository.ProdutoRepository;
import br.com.produtos.apirest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public ResponseEntity<ProdutoModel> findById(long id) {

        return produtoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @Override
    public ProdutoModel create(ProdutoModel produtoModel) {

        return produtoRepository.save(produtoModel);

    }

    @Override
    public ResponseEntity update(long id, ProdutoModel produtoModel) {

        return produtoRepository.findById(id)
                .map(record -> {
                    record.setNome(produtoModel.getNome());
                    record.setDescricao(produtoModel.getDescricao());
                    record.setValorUnitario(produtoModel.getValorUnitario());
                    ProdutoModel updated = produtoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity deleteById(long id) {

        return produtoRepository.findById(id)
                .map(record -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

    }
}
