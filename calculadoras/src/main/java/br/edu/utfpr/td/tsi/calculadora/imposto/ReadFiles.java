package br.edu.utfpr.td.tsi.calculadora.imposto;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ReadFiles {

    //public static ArrayList<Prodution> ReadProdutionFile() {
    //     ArrayList<Prodution> producaos = new ArrayList<Prodution>();
    //     final Gson gson = new Gson();
    //     try (FileReader reader = new FileReader("calculadoras\\gson\\relatorioProducao2.json")) {
    //         producaos = gson.fromJson(reader, new TypeToken<ArrayList<Prodution>>() {
    //         }.getType());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return producaos;
    // }
    public static ArrayList<Prodution> readProdutionFile(Reader reader) {
        ArrayList<Prodution> producaos = new ArrayList<>();
        final Gson gson = new Gson();
        try {
            producaos = gson.fromJson(reader, new TypeToken<ArrayList<Prodution>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producaos;
    }

    public static ArrayList<Prodution> ReadProdutionFile() {
        try (Reader reader = new FileReader("calculadoras\\gson\\relatorioProducao2.json")) {
            return readProdutionFile(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
