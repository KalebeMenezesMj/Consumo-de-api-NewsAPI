package br.edu.fatecpg.newsapi.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaApi {

    String apikey="ad2904ef94324594b181b6674501b6eb";

    public String buscarNoticias(String tema, int quantidade){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://newsapi.org/v2/everything?q="+tema+"&sortBy=publishedAt&pageSize="+quantidade+
                            "&apiKey="+apikey))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
