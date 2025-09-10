package br.edu.fatecpg.newsapi.view;

import br.edu.fatecpg.newsapi.model.Noticia;
import br.edu.fatecpg.newsapi.service.BuscaApi;
import com.google.gson.Gson;

import java.lang.reflect.Type;

import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        BuscaApi ba = new BuscaApi();
        Gson gson = new Gson();

        String respostaJson = ba.buscarNoticias("bolsonaro", 3);

        JsonObject jsonObject = JsonParser.parseString(respostaJson).getAsJsonObject();
        JsonArray artigos = jsonObject.getAsJsonArray("articles");

        for (JsonElement elem : artigos) {
            Noticia noticia = gson.fromJson(elem, Noticia.class);
            System.out.println(noticia);
        }
    }
}

