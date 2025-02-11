package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxPara implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal valueTax = BigDecimal.ZERO;

        valueTax = valueTax.add(prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade())
            .divide(new BigDecimal("14.14", MathContext.DECIMAL128).setScale(2, RoundingMode.UP))));

        return valueTax;
    }

}
