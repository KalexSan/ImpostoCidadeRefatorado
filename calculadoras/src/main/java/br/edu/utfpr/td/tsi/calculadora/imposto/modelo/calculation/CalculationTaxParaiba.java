package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxParaiba implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
       BigDecimal divisor = new BigDecimal("30.30");
       BigDecimal totalValue = prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade()));
       BigDecimal valueTax = totalValue.divide(divisor, MathContext.DECIMAL32).setScale(2, RoundingMode.UP);
       return valueTax;
    }

}
