package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxMatoGrosso implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal divisor = new BigDecimal("15.15").setScale(10, RoundingMode.HALF_UP);
        BigDecimal totalValue = prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade()));
        BigDecimal valueTax = totalValue.divide(divisor, MathContext.DECIMAL32).setScale(2, RoundingMode.UP);

                if (prodution.getProduto().isAgriculturaFamiliar()) {
                    valueTax = valueTax.multiply(new BigDecimal("0.75")).setScale(2, RoundingMode.UP);
                } if (prodution.getProduto().getPeso() != null && prodution.getProduto().getPeso().compareTo(new BigDecimal("89")) > 0) {
                    BigDecimal adicional = new BigDecimal(prodution.getQuantidade()).multiply(new BigDecimal("1.25"));
                    valueTax = valueTax.add(adicional);
                } if (!prodution.getProduto().isOrganico()) {
                    valueTax = valueTax.multiply(new BigDecimal("1.35")).setScale(2, RoundingMode.UP);
                }
            return valueTax;
    }

}
