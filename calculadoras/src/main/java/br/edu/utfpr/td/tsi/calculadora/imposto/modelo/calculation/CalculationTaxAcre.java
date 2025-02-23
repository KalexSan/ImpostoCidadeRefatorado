package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxAcre implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal divisor = new BigDecimal("11.11");
        BigDecimal totalValue = prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade()));
        BigDecimal valueTax = totalValue.divide(divisor, MathContext.DECIMAL32).setScale(2, RoundingMode.UP);
                  
                if (prodution.getProduto().isAgriculturaFamiliar()) {
                    valueTax = valueTax.multiply(new BigDecimal("0.75")).setScale(2, RoundingMode.UP);
                }

            return valueTax;
    }
    

}
