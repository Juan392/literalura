package com.example.literalura.literalura.principal;

import com.example.literalura.literalura.model.*;
import com.example.literalura.literalura.repository.IRepository;
import com.example.literalura.literalura.service.ConsumoApi;
import com.example.literalura.literalura.service.Convertidor;
import org.aspectj.apache.bcel.util.Repository;

import java.util.List;
import java.util.Scanner;

import static com.example.literalura.literalura.service.GeminiAi.resumir;

public class Menu {
    private final String URL_BASE ="https://gutendex.com/books/?";
    private Scanner console = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private Convertidor convertirDatos = new Convertidor();
    private IRepository repository;

    public Menu(IRepository repository) {
        this.repository = repository;
    }

    public void mostrarMenu() {
        System.out.println("""
                🟠㊝Bienvenido a tu biblioteca personal🟠㊝
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢠⠳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⢸⢸⢳⡙⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⡏⠀⠀⠀⢸⠀⠐⡜⣆⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢞⠵⢸⠀⠀⢀⡇⣸⠀⡆⠘⣌⢆⠀⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢞⡵⠁⡆⡇⠀⡠⠋⡼⠀⠀⡇⠀⠘⠈⢧⡏⡄⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢠⠀⠀⠀⠀⢀⡴⣡⡯⠀⢀⡇⣧⠞⠁⡰⠃⠀⠀⣧⠀⠀⠀⢸⡇⢃⢸⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢸⡀⠀⠀⢠⢎⡜⡿⠁⠀⢸⣇⡵⠁⠀⠀⠀⠀⠀⣿⠀⠀⠀⠈⠀⢸⣸⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢸⢣⠀⡴⣡⣿⠁⠃⠀⢀⣾⡿⠁⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠈⡏⠀⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢸⠈⢇⡇⣿⡏⠀⠀⠀⣼⣿⠃⠀⠀⠀⠀⢀⠇⡰⣿⠀⠀⠀⠀⠀⡇⠁⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠸⠐⠄⠀⠏⡇⠀⠀⣧⣿⡇⡀⡜⢰⠀⠀⡘⡐⠁⠏⡆⠀⠀⡄⢠⡇⡄⠀⠈⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠈⠦⢠⣧⠀⣆⣿⣿⢁⣷⣇⡇⠀⣴⣯⠀⠀⠀⡇⠀⣸⡇⣾⡿⠁⠀⡀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⢀⠀⠀⠀⢀⢀⢠⠀⠸⣿⣆⢹⣿⣿⣾⣿⣿⣠⢾⠛⠁⠀⠀⠀⡇⡠⡟⣿⣿⠃⠀⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠘⡶⣄⠀⢸⠸⣼⣧⡀⣿⣿⣾⣿⣿⣿⣿⣿⡇⠘⠀⡀⠀⠀⢠⠟⠀⠃⢹⣥⠃⠀⢠⢏⣜⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠙⡌⠳⢄⣣⠹⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⡇⠀⠀⢀⣄⣴⡢⠀⠀⠀⡿⣯⠀⠐⠁⠘⣻⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠘⢎⢶⣍⣀⠈⢿⣿⣿⣿⣿⣿⣿⣦⠑⣤⡀⠀⣰⠟⡿⠁⠀⠀⠈⠀⠁⠀⠀⡀⡰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠈⢣⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠘⣷⣾⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⡵⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠑⣝⠻⠿⣿⣿⣿⣿⣿⣿⣿⣇⠀⣿⣿⣿⣇⣀⣤⠆⠀⠁⠀⠉⠀⠸⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠈⠉⡇⢸⣿⣿⣿⣿⣿⣿⣿⣼⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠐⢤⡀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠱⢬⣙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⡄⠀⠀⠀⠀⠀⠀⠈⠻⠆⠀⠈⠑⠒⣿⣦⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠑⠲⣼⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⣀⣀⣀⠀⠀⣀⣀⣠⣴⣾⣾⣿⣿⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣘⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⠤⣀⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⢘⣿⠟⣡⣶⣶⣤⡄⠙⣿⣿⣿⣿⣿⣿⣟⡛⠿⠿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣿⣿⡿⠟⣩⣿⣿⣿⣿⡀⠀⠀⢏⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣶⣿⢋⣼⢿⠿⢛⣿⠷⢶⣶⠂⠿⣿⣿⣿⣿⣿⣷⣶⣤⣀⡀⠉⠉⠀⠀⣀⣀⡀⠀⠀⠀⠠⢾⣿⣿⣿⣿⣿⠇⠀⠀⣘⠢⡀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢀⣽⠁⠘⠁⠀⠀⠁⠀⠠⠟⠛⣿⣄⡩⢉⣿⣿⣿⣿⣿⡿⠋⠀⡠⣶⣶⣶⡶⣶⣶⣾⠿⠶⠀⠀⠻⣿⣿⣿⣿⠀⠀⠠⣿⣷⡘⢆⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⡸⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⣿⣿⣤⡈⣿⣿⣿⣿⡟⠁⣠⣾⡇⠀⣿⣿⣆⠀⠀⠀⠀⣀⣠⣆⠀⢹⣿⣿⡿⠀⠀⢠⣿⣿⣿⡘⡆⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⠁⣺⣿⣿⣿⡿⠀⢰⡟⠛⠇⠘⠿⣿⣇⠀⠀⣀⠀⢀⣽⣿⡀⠀⣿⣿⠃⠀⠀⢸⣿⣿⣿⣧⢸⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢣⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⣿⠃⢰⠨⣿⣿⣿⠃⠀⣿⡇⢀⠀⢰⠀⠛⠛⠀⠀⠛⠀⠈⠉⠹⠇⠀⣿⡏⠀⠀⠀⣹⣿⣿⣿⣿⠘⢦⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⠀⠀⣠⡶⠋⠁⡼⠃⠀⣾⠃⣿⣿⣿⠀⠀⡟⢀⡜⠀⢋⣠⣶⠀⠀⠒⠒⠀⠀⣶⡾⠀⢠⠏⠀⠀⣠⣾⣿⣿⣿⣿⢿⠁⠀⣣⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣼⣷⢤⣤⢶⠟⠁⠀⠀⠀⠀⢀⣼⡏⣸⣿⣿⣿⣇⠀⢻⣿⡇⠀⣿⣿⣿⠀⠀⣶⣶⠀⢸⣿⠃⠀⠎⠀⠀⠀⠿⣿⣿⣿⣿⡿⠀⠀⢀⣯⢇⠀⠀
                ⠀⠀⠀⠀⠀⠀⢰⣿⣿⠘⠁⠁⠀⠀⢀⣠⣴⣾⣿⠟⣰⣿⣿⣿⣿⣿⡄⠀⠻⠀⣠⣿⣿⣿⠀⠀⠉⠉⠀⠘⠁⢀⠌⠀⠀⠀⢀⠀⠀⠈⠉⠀⠀⠀⢀⣾⣿⡿⠀⠀
                ⠀⠀⠀⠀⠀⠀⡟⣿⡏⠀⠀⢀⣠⣾⣿⣿⡿⠛⣡⠀⣿⣿⣿⣿⣿⣿⣿⣦⣀⠈⠙⠻⠿⠿⠶⠾⠟⠃⠀⢀⠔⠁⠀⠀⠀⠀⣾⣆⠀⠀⠀⠀⣰⢀⣾⣿⣿⣧⡇⠀
                ⠀⠀⠀⠀⠀⢸⠁⣿⠃⢀⣴⣿⣿⣿⠟⢻⢁⣾⣿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣄⣀⡀⠠⠤⠐⠊⠀⠀⠀⠀⠀⢀⡰⣿⣿⡆⠀⠀⣿⣧⣿⣿⣿⣿⣿⡇⠀
                ⠀⠀⠀⠀⠀⣌⠀⠘⢠⣿⣿⣿⡟⠁⢀⣏⣾⣿⡇⣸⣿⣿⣿⣿⣿⣟⠛⠛⠛⠛⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠋⢱⣿⣿⣧⠀⢠⣿⣿⣿⣿⣿⣿⡏⢱⠀
                ⠀⠀⠀⠀⠀⠈⠑⠢⢿⣿⣿⡟⠀⢀⣾⣿⣿⡟⢠⣿⣿⣿⣿⡿⠿⢿⣿⣷⣶⣤⣤⣤⣄⣤⣤⣤⠤⠖⠂⠀⠀⣠⠊⠀⠀⠀⢿⣿⣿⠀⢸⣿⣿⣿⣿⣿⣿⠇⢸⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠣⢤⣈⣿⣿⠏⣰⣿⣿⣿⣷⣭⣍⣑⠂⠀⠀⠈⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⢀⡼⠁⠀⠀⠀⠀⠈⢿⢿⠀⣼⣿⣿⣿⣿⣿⣧⢴⣾⡄
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠑⠚⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠶⠶⠶⠖⠒⠂⠀⠀⠀⠀⢠⠞⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⣿⣿⣿⣿⣿⣿⣡⣿⣿⡇
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠓⠒⠒⠒⠒⠒⠒⠒⠒⠊⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠱⠤⠛⠛⠿⠯⠭⠭⠙⠒⠚⠁
                """);
        var salida= false;
        while (!salida) {
            System.out.print("""
                    \t\t\t
                    ㊝Este programa te permite:
                    🐉1 - Agregar un libro.🐉
                    🐉2 - Mostrar Libros Agregados.🐉
                    🐉3 - Mostrar Autores Agregados.🐉
                    🐉4 - Mostrar Autores vivos de determinado tiempo.🐉
                    🐉5 - Mostrar Libros Por Idioma.🐉
                    🐉6 - Hacer un resumen sobre un libro.🐉
                    🐉7 - Salir.🐉
                    ㊝
                    
                    ㊝Seleccione una opcion: 
                    """);
            var opcion = console.nextInt();
            System.out.print("㊝");
            console.nextLine();
            switch(opcion){
                case 1 -> agregarUnLibro();
                case 2 -> mostrarLibros();
                case 3 -> mostrarAutores();
                case 4 -> mostrarAutoresPorFecha();
                case 5 -> mostrarPorIdioma();
                case 6 -> hacerResumen();
                case 7 -> salida = true;
                default -> System.out.println("㊝Opcion invalida, vuelva a ingresar su opcion.㊝");
            }
        }
    }

    private void hacerResumen() {
        System.out.println("Ingresa el nombre del libro para resumir: ");
        var libro = console.nextLine();
        System.out.println(resumir(libro));
    }

    private void mostrarAutoresPorFecha() {
        System.out.println("🐲☯Ingresa el año de inicio🐲☯: ");
        var nacimiento = console.nextLong();
        console.nextLine();
        System.out.println("🐲☯Ingresa el año de finalizacion🐲☯: ");
        var fallecimiento = console.nextLong();
        console.nextLine();
        repository.findByAutorNacimientoGreaterThanEqualAndAutorFallecimientoLessThanEqual(nacimiento,fallecimiento);
    }

    private void mostrarPorIdioma() {
        System.out.println("""
                ⛩Nuestros idiomas:
                🐲☯ 🇪🇸 - Español 🥘
                🐲☯ 🇬🇧 - Inglés 🍵 
                🐲☯ 🇫🇷 - Francés 🥐 
                🐲☯ 🇩🇪 - Alemán 🍺 
                🐲☯ 🇮🇹 - Italiano 🍕 
                🐲☯ 🇵🇹 - Portugués 🥖 
                🐲☯ 🇳🇱 - Neerlandés 🌷
                🐲☯ 🇷🇺 - Ruso 🪆 
                🐲☯ 🇯🇵 - Japonés 🍣 
                🐲☯ 🇨🇳 - Chino 🐉 
                
                ⛩
                """);
        System.out.println("⛩Ingresa el idioma en el que desea buscar⛩: ");
        var lenguaje = console.nextLine();
        List<Libro> libros = repository.findByLenguaje(Lenguaje.fromString(lenguaje));
        System.out.println("🐲☯Los libros en ese idioma son🐲☯: ");
        libros.forEach(System.out::println);
    }

    private void mostrarAutores() {
        System.out.println("⛩Ingresa el autor⛩: ");
        var nombre = console.nextLine();
        List<Libro> libros = repository.findByAutor_AutorIgnoreCase(nombre);
        System.out.println("🐲☯Los libros del autor🐲☯: ");
        libros.forEach(System.out::println);
    }

    private void mostrarLibros() {
        System.out.println("⛩Los libros en tu biblioteca son⛩: ");
        List<Libro> libros = repository.findAll();
        libros.forEach(System.out::println);
    }

    private void agregarUnLibro() {
        System.out.println("⍟Ingresa el nombre del libro⍟: ");
        var nombre = console.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+"search="+nombre.replace(" ", "+"));
        var respuesta = convertirDatos.convertidorDatos(json, DatosRespuesta.class);
        var libro = new Libro(respuesta.resultados().get(0));
        System.out.println(libro);
        repository.save(libro);
    }
}
