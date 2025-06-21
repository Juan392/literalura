package com.example.literalura.literalura.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GeminiAi {
    private static final String MODELO = "gemini-2.0-flash-lite";
    private static final String API = "AIzaSyCKNgf1rM6PFyIUsyGVSsijonml1j8U7rA";

    private static String conexion(Client client, String prompt){
        try{
            GenerateContentResponse response =  client.models.generateContent(MODELO, prompt, null);
            if(!response.text().isEmpty()){
                return response.text();
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error" + e.getMessage());
        }
        return  null;
    }

    public static String traduccion(String text){
        var prompt = "Necesito que traduzcas lo siguinte al español y lo resumas a 255 caracteres, la respuesta quiero que sea en texto plano y directa sin que agregues mas texto que no sea la traduccion"+ text;
        var client = new Client.Builder().apiKey(API).build();
        return conexion(client,prompt);
    }

    public static String resumir(String text){
        var prompt = "Necesito que hagas un resumen sobre este libro: " + text + ". La respuesta debe ser sin adorno, en texto plano y directa, sin que agregues mas que el resumen.";
        var client = new Client.Builder().apiKey(API).build();
        return  conexion(client,prompt);
    }
}
