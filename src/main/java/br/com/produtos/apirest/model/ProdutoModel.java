package br.com.produtos.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="TB_PRODUTO")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="VALOR_UNITARIO")
    private BigDecimal valorUnitario;

    @Column(name="DESCRICAO")
    private String descricao;

}
