package com.example.literalura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Convertidor implements  IConvertidor{
    public ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertidorDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return null;
    }


}
