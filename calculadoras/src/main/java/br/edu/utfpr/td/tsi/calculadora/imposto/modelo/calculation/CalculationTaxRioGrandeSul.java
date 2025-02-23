package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxRioGrandeSul implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal divisor = new BigDecimal("20.20");
        BigDecimal totalValue = prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade()));
        BigDecimal valueTax = totalValue.divide(divisor, MathContext.DECIMAL32).setScale(2, RoundingMode.UP);

        return valueTax;
    }

}
