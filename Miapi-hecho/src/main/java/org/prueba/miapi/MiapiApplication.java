package org.prueba.miapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@EnableCaching
@SpringBootApplication
public class MiapiApplication {

    static List<Personaje> personajes = new ArrayList<>();

    public static void main(String[] args) {
    Cargar();
    SpringApplication.run(MiapiApplication.class, args);
    }
    public static void Cargar(){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://rickandmortyapi.com/api/character/")).GET().build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            ArrayNode getpersonajes = new ObjectMapper()
                    .readTree(response.body())
                    .get("results")
                    .asArray();
            System.out.println(getpersonajes.get(1).findValue("id"));

            for(int i = 0; i<getpersonajes.size(); i++){
                int id = getpersonajes.get(i).findValue("id").asInt();
                String name = getpersonajes.get(i).findValue("name").asText();
                String especie =getpersonajes.get(i).findValue("species").asText();
                String status = getpersonajes.get(i).findValue("status").asText();
                String origin = getpersonajes.get(i).findValue("origin").get("name").asText();
                Personaje temp = new Personaje(id, name, especie, status, origin);
                personajes.add(temp);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
