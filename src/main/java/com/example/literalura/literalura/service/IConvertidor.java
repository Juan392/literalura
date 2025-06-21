package com.example.literalura.literalura.service;

public interface IConvertidor {
    <T> T convertidorDatos(String json, Class<T> clase);

}