package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxRondonia implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal valueTax = BigDecimal.ZERO;

        valueTax = valueTax.add(prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade())
            .divide(new BigDecimal("24.24", MathContext.DECIMAL128).setScale(2, RoundingMode.UP))));

        return valueTax;
    }

}
