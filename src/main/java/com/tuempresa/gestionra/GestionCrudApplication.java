
package com.tuempresa.gestionra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCrudApplication.class, args);
        System.out.println("¡API REST INICIADA CORRECTAMENTE EN EL PUERTO 8080!");
    }
}