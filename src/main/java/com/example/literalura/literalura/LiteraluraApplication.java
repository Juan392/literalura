package com.example.literalura.literalura;

import com.example.literalura.literalura.principal.Menu;
import com.example.literalura.literalura.repository.IRepository;
import com.example.literalura.literalura.service.ConsumoApi;
import com.example.literalura.literalura.service.Convertidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private IRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(repository);
		menu.mostrarMenu();
	}

}
