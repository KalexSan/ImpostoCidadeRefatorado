package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Product;
import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxMatoGrosso implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal valueTax = BigDecimal.ZERO;
        BigDecimal divisor = new BigDecimal("15.15").setScale(10, RoundingMode.HALF_UP);
            
            valueTax = valueTax.add(prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade())
                .divide(divisor, MathContext.DECIMAL128).setScale(2, RoundingMode.UP)));

                Product product = new Product();
                if (product.isAgriculturaFamiliar()) {
                    valueTax = valueTax.multiply(new BigDecimal("0.75"));
                } if (product.getPeso() != null && product.getPeso().compareTo(new BigDecimal("89")) > 0) {
                    BigDecimal adicional = new BigDecimal(prodution.getQuantidade()).multiply(new BigDecimal("1.25"));
                    valueTax = valueTax.add(adicional);
                } if (!product.isOrganico()) {
                    valueTax = valueTax.multiply(new BigDecimal("1.35"));
                }
            return valueTax;
    }

}
