package com.example.literalura.literalura.model;

public enum Lenguaje {
    ES ("es"), // Español
    EN ("en"), // Inglés
    FR ("fr"), // Francés
    DE ("de"), // Alemán
    IT ("it"), // Italiano
    PT ("pt"), // Portugués
    NL ("nl"), // Neerlandés
    RU ("rs"), // Ruso
    JA ("jp"), // Japonés
    ZH ("zh"); // Chino

    private String lenguaje;
    Lenguaje (String lenguaje){
        this.lenguaje = lenguaje;
    }

    public static Lenguaje fromString(String text){
        for(Lenguaje lenguaje: Lenguaje.values()){
            if (lenguaje.lenguaje.equalsIgnoreCase(text)){
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningun lenguaje encontrada: " + text);
    }
}
