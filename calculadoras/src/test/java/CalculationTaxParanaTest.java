import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.td.tsi.calculadora.imposto.FederalUnit;
import br.edu.utfpr.td.tsi.calculadora.imposto.Product;
import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxParana;

public class CalculationTaxParanaTest {
    private CalculationTaxParana taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new CalculationTaxParana();
    }

    @Test
    public void testCalculateTaxCasoBase() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(false);
        product.setPeso(new BigDecimal("50.00")); 
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("7.62");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxAgriculturaFamiliar() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        product.setOrganico(false);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("5.72");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxOrganico() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(true);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("6.67");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxPesoExcedente() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(false);
        product.setPeso(new BigDecimal("90.00")); 
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("10.12");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxAgriculturaFamiliarEOrganico() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        product.setOrganico(true);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("5.01");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxPesoExcedenteEAgriculturaFamiliar() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        product.setOrganico(false);
        product.setPeso(new BigDecimal("90.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("8.22");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxQuantidadeZero() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(false);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 0, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxPesoNulo() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(false);
        product.setPeso(null); 
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.PARANA);

        BigDecimal expectedTax = new BigDecimal("7.62");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }
}
