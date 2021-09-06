package br.com.produtos.apirest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="TB_PRODUTO")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="VALOR_UNITARIO")
    private BigDecimal valorUnitario;

    @Column(name="DESCRICAO")
    private String descricao;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
