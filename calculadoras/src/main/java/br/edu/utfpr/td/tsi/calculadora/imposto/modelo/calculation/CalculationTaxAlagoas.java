package br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;

public class CalculationTaxAlagoas implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(Prodution prodution) {
        BigDecimal divisor = new BigDecimal("10.10");
        BigDecimal totalValue = prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade()));
        BigDecimal valueTax = totalValue.divide(divisor, MathContext.DECIMAL32).setScale(2, RoundingMode.UP);
                
               if (prodution.getProduto().isAgriculturaFamiliar()) {
                valueTax = valueTax.multiply(new BigDecimal("0.75")).setScale(2, RoundingMode.UP);
               } if (prodution.getProduto().getPeso() != null && prodution.getProduto().getPeso().compareTo(new BigDecimal("89")) > 0) {
                BigDecimal adicional = new BigDecimal(prodution.getQuantidade()).multiply(new BigDecimal("1.25")).setScale(2, RoundingMode.UP);
                valueTax = valueTax.add(adicional);
            }

            return valueTax;
    }

}
