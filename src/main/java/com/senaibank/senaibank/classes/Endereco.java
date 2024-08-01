package com.senaibank.senaibank.classes;

import jakarta.persistence.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import lombok.Data;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String cep;

    private String logradouro;
    private String bairro;
    private String localidade;
    private String complemento;
    
    // Transformar em ENUM
    private String uf;

    public static Endereco getEnderecoByCep(String cep) {
        
        Endereco endereco = new Endereco();
        OkHttpClient client = new OkHttpClient();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Request request = new Request.Builder().
        url(url).
        build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null){
                String result = response.body().string();

                // Mapper
                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);

            } else {
                System.out.println("Erro ao buscar o CEP: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
        }

        return endereco;
    }

}
