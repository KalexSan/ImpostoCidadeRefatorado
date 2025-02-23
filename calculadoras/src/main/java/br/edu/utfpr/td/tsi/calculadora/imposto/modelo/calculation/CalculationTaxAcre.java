package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Product;
import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxAcre implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal valueTax = BigDecimal.ZERO;
        BigDecimal divisor = new BigDecimal("11.11").setScale(10, RoundingMode.HALF_UP);
        Product product = new Product();
            valueTax = valueTax.add(prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade())
                .divide(divisor, MathContext.DECIMAL128).setScale(2, RoundingMode.UP)));
                
                if (product.isAgriculturaFamiliar()) {
                    valueTax = valueTax.multiply(new BigDecimal("0.75"));
                }

            return valueTax;
    }
    

}
