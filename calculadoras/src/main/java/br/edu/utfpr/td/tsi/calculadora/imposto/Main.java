package br.edu.utfpr.td.tsi.calculadora.imposto;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

import br.edu.utfpr.td.tsi.calculadora.imposto.modelo.calculation.TaxCalculation;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Prodution> listProdution = ReadFiles.ReadProdutionFile();
        

        BigDecimal TotalTax = BigDecimal.ZERO;
        BigDecimal TotalValue = BigDecimal.ZERO;

        for (Prodution prodution : listProdution) {
            TaxCalculation taxCalculation = prodution.getLocalProducao().taxCalculation();
            TotalTax = TotalTax.add(taxCalculation.calculateTax(prodution));
            TotalValue = TotalValue.add(prodution.getValorUnitario().multiply(new BigDecimal(prodution.getQuantidade())));
        }

        String valorImpostoFormato = NumberFormat.getCurrencyInstance().format(TotalTax);
        String valorTotalFormato = NumberFormat.getCurrencyInstance().format(TotalValue);
        System.out.println(String.format("Valor total dos impostos: %s", valorImpostoFormato));
        System.out.println(String.format("Valor total dos produção: %s", valorTotalFormato));

    }
    
}