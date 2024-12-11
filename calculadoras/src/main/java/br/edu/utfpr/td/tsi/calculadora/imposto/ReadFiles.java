package br.edu.utfpr.td.tsi.calculadora.imposto;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ReadFiles {

    public static ArrayList<Prodution> ReadProdutionFile() {
        ArrayList<Prodution> producaos = new ArrayList<Prodution>();
        final Gson gson = new Gson();
        try (FileReader reader = new FileReader("calculadoras\\gson\\relatorioProducao2.json")) {
            producaos = gson.fromJson(reader, new TypeToken<ArrayList<Prodution>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producaos;
    }
}
