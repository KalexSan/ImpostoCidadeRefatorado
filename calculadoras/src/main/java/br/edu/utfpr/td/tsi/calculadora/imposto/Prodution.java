package br.edu.utfpr.td.tsi.calculadora.imposto;

import java.math.BigDecimal;

public class Prodution {

    private Product produto;
    private int quantidade;
    private BigDecimal valorUnitario;
    private FederalUnit localProducao;

    public Prodution(Product produto, int quantidade, BigDecimal valorUnitario, FederalUnit localProducao) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.localProducao = localProducao;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public FederalUnit getLocalProducao() {
        return localProducao;
    }

    public void setLocalProducao(FederalUnit localProducao) {
        this.localProducao = localProducao;
    }
}
