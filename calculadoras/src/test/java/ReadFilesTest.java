import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.td.tsi.calculadora.imposto.Prodution;
import br.edu.utfpr.td.tsi.calculadora.imposto.ReadFiles;

public class ReadFilesTest {
    private String jsonValido;
    private String jsonVazio;
    private String jsonInvalido;

    @Before
    public void setUp() throws Exception {
        jsonValido = "[{\"quantidade\":\"65\",\"valorUnitario\":\"28.71\",\"localProducao\":\"RONDONIA\",\"produto\":{\"nome\":\"Beef - Short Ribs\",\"peso\":\"93.75\",\"volume\":\"1.77\",\"organico\":\"false\",\"agriculturaFamiliar\":\"false\"}}]";

        jsonVazio = "[]";

        jsonInvalido = "[{invalid json}]";
    }

    @Test
    public void testLeituraJsonValido() throws Exception {
        StringReader reader = new StringReader(jsonValido);
        ArrayList<Prodution> resultado = ReadFiles.readProdutionFile(reader);

        assertEquals(1, resultado.size());
        assertEquals(65, resultado.get(0).getQuantidade());
        assertEquals(new BigDecimal("28.71"), resultado.get(0).getValorUnitario());
        assertEquals("RONDONIA", resultado.get(0).getLocalProducao().name());
        assertEquals("Beef - Short Ribs", resultado.get(0).getProduto().getNome());
        assertEquals(new BigDecimal("93.75"), resultado.get(0).getProduto().getPeso());
        assertEquals(new BigDecimal("1.77"), resultado.get(0).getProduto().getVolume());
        assertEquals(false, resultado.get(0).getProduto().isOrganico());
        assertEquals(false, resultado.get(0).getProduto().isAgriculturaFamiliar());
    }

    @Test
    public void testLeituraArquivoJsonVazio() {
        StringReader reader = new StringReader(jsonVazio);
        ArrayList<Prodution> resultado = ReadFiles.readProdutionFile(reader);

        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testLeituraArquivoJsonInvalido() {
        StringReader reader = new StringReader(jsonInvalido);
        ArrayList<Prodution> resultado = ReadFiles.readProdutionFile(reader);

        assertTrue(resultado.isEmpty());
    }

}
