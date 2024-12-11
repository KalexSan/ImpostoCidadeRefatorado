package br.edu.utfpr.td.tsi.calculadora.imposto;

import java.math.BigDecimal;

public class Product {

    private String nome;
    private BigDecimal peso;
    private BigDecimal volume;
    private boolean organico;
    private boolean agriculturaFamiliar;

    public Product(String nome, BigDecimal peso, BigDecimal volume, Boolean organico, Boolean agriculturaFamiliar) {
        this.nome = nome;
        this.peso = peso;
        this.volume = volume;
        this.organico = organico;
        this.agriculturaFamiliar = agriculturaFamiliar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public boolean getOrganico() {
        return organico;
    }

    public void setOrganico(boolean organico) {
        this.organico = organico;
    }
    
    public boolean getAgriculturaFamiliar() {
        return agriculturaFamiliar;
    }

    public void setAgriculturaFamiliar(boolean agriculturaFamiliar) {
        this.agriculturaFamiliar = agriculturaFamiliar;
    }
}
