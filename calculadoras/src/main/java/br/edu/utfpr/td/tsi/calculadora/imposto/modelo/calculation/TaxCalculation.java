package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public interface TaxCalculation {

    public BigDecimal calculateTax(Prodution prodution);

}
