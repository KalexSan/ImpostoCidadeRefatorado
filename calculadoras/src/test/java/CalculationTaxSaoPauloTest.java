import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.td.tsi.calculadora.imposto.FederalUnit;
import br.edu.utfpr.td.tsi.calculadora.imposto.Product;
import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;
import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.CalculationTaxSaoPaulo;

public class CalculationTaxSaoPauloTest {
    private CalculationTaxSaoPaulo taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new CalculationTaxSaoPaulo();
    }

    @Test
    public void testCalculateTaxCasoBase() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(true); // Orgânico = true evita o acréscimo de 1.35
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("8.61");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxAgriculturaFamiliar() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        product.setOrganico(true);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("6.46");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxPesoExcedente() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(true);
        product.setPeso(new BigDecimal("90.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("11.11");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxNaoOrganico() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(false); // Não orgânico aplica 1.35
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("11.63");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxAgriculturaFamiliarENaoOrganico() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        product.setOrganico(false);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("8.73");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxPesoExcedenteEAgriculturaFamiliar() {
        Product product = new Product();
        product.setAgriculturaFamiliar(true);
        product.setOrganico(true);
        product.setPeso(new BigDecimal("90.00"));
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("8.96");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxQuantidadeZero() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(true);
        product.setPeso(new BigDecimal("50.00"));
        Prodution prodution = new Prodution(product, 0, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }

    @Test
    public void testCalculateTaxPesoNulo() {
        Product product = new Product();
        product.setAgriculturaFamiliar(false);
        product.setOrganico(true);
        product.setPeso(null); // Peso nulo não deve influenciar no cálculo
        Prodution prodution = new Prodution(product, 2, new BigDecimal("100.00"), FederalUnit.SAO_PAULO);

        BigDecimal expectedTax = new BigDecimal("8.61");
        BigDecimal result = taxCalculator.calculateTax(prodution);
        assertEquals(expectedTax, result);
    }
}
