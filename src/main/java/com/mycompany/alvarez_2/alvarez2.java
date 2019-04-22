/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alvarez_2;

import java.io.File;
import java.util.List;
import datos.Polera;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JAVIER
 */
public class alvarez2 {

    public static void main(String[] args) {
        ArrayList<Polera> listaPedidos = new ArrayList<Polera>();

        menu(listaPedidos);
    }

    public static String[] separarPedidos(String texto) {// ingresa un texto y lo separa en un array de string segun saltos y comas.
        String[] separacion = texto.split("[\n ,]+");
        return separacion;
    }

    public static int contarPedidos(String texto) {// cuenta la cantidad de pedidos que tiene el archivo .csv
        String[] separacion = texto.split("[\n ,]+");
        int cantidad = (separacion.length / 3) - 1;
        return cantidad;
    }

    public static void agregarPedidos(ArrayList<Polera> listaPedidos) {//crea objetos en un array e ingresa informacion recibida de un archivo .csv
        String nombre = nombreArchivo();
        String texto = readFile(nombre);
        String[] pedidos = separarPedidos(texto);
        int cantidadPedidos = contarPedidos(texto);

        for (int i = 1; i < cantidadPedidos + 1; i++) {
            String material = pedidos[3 * i];// Segun la estructura de el .csv el material siempre estara cada 3 espacios
            String talla = pedidos[3 * i + +1];
            boolean estampado = Boolean.parseBoolean(pedidos[3 * i + 2]);
            listaPedidos.add(new Polera(material, talla, estampado));
            
            String reescribir = readFile("listado.csv") + "\n" + texto;
            writeFile("listado.csv", reescribir);

        }

    }

    public static void mostrar(ArrayList<Polera> listaPedidos) {//muestra un array completo y los atributos de sus objetos.
        for (int i = 0; i < listaPedidos.size(); i++) {
            System.out.println("Polera numero " + (i + 1));
            System.out.println(listaPedidos.get(i).getMaterial());
            System.out.println(listaPedidos.get(i).getTalla());
            System.out.println(listaPedidos.get(i).isEstampado() + "\n");

        }
    }

    
    public static String readFile(String nombre) {//metodo que lee un archivo y devuelve su contenido como String

        Path archivo = Paths.get(nombre);
        String Contenido = "";
        try {
            Contenido = new String(Files.readAllBytes(archivo));
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo.");
        }
        return Contenido;
    }

    
    public static void writeFile(String nombre, String texto) {//borra la informacion de un archivo y la reescribe con otra
        Path file = Paths.get(nombre);
        try {
            Files.write(file, texto.getBytes());
        } catch (Exception e) {
            System.out.println("The file could not be written");
        }
    }

    public static void nuevaPolera(ArrayList<Polera> listaPedidos) {

        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese material:");
        String material = read.nextLine();
        System.out.print("Ingrese talla:");
        String talla = read.nextLine();
        System.out.print("¿desea estampado?, ingresar true o false \n");
        boolean estampado = read.nextBoolean();

        listaPedidos.add(new Polera(material, talla, estampado));
        String reescribir;
        reescribir = readFile("listado.csv") + "\n" + material + "," + talla + "," + estampado;
        writeFile("listado.csv", reescribir);

    }

    public static String nombreArchivo() {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese nombre del archivo: \n");
        String texto = read.nextLine();
        return texto;
    }

    public static void menu(ArrayList<Polera> listaPedidos) {
        Scanner read = new Scanner(System.in);
        System.out.print("Inserte 1 si quiere agregar una polera. \n"
                + "inserte 2 si quiere agregar un pedido. \n"
                + "inserte 3 si desea ver revisar pedidos. \n"
                + "inserte 4 si ya ha terminado. \n");
        int accion = read.nextInt();
        switch (accion) {
            case 1:
                nuevaPolera(listaPedidos);
                menu(listaPedidos);
                break;
            case 2:
                agregarPedidos(listaPedidos);
                menu(listaPedidos);
                break;
            case 3:
                mostrar(listaPedidos);
                menu(listaPedidos);
                break;
            case 4:
                System.out.println("Nos vemos");
                System.exit(0);
                break;
            default:
                System.out.println("Numero incorrecto, intentar nuevamente");
                menu(listaPedidos);
        }
    }
}
