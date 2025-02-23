import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.td.tsi.calculadora.imposto.FederalUnit;
import br.edu.utfpr.td.tsi.calculadora.imposto.Product;
import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxAcre;

public class CalculationTaxAcreTest {
    
    private CalculationTaxAcre taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new CalculationTaxAcre();
    }

    @Test
    public void testCalculateTaxSemAgriculturaFamiliar() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.ACRE);

        BigDecimal tax = new BigDecimal("18.01");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(tax, result);
    }

    @Test
    public void testCalculateTaxComAgriculturaFamiliar() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.ACRE);

        BigDecimal tax = new BigDecimal("13.51");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(tax, result);

    }
    
    @Test
    public void testCalculateTaxQuantidadeZero() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        Prodution prodution = new Prodution(product, 0, new BigDecimal("100.00"), FederalUnit.ACRE);

        BigDecimal tax = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
        BigDecimal result = taxCalculator.calculateTax(prodution);

        assertEquals(tax, result);
    }

    @Test
    public void testCalculateTaxValorUnitarioZero() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        Prodution prodution = new Prodution(product, 5, BigDecimal.ZERO, FederalUnit.ACRE);

        BigDecimal tax = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
        BigDecimal result = taxCalculator.calculateTax(prodution);

        assertEquals(tax, result);
    }
}
