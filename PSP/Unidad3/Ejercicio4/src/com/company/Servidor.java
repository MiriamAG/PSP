package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
// Programa que conectándose vía socket a un servidor que recibiendo tramas
        //finalizadas por el salto de linea responde con la misma linea convertida a mayúsculas,
        //le envía al servidor todo lo que escribe el usuario y le muestra en pantalla la
        //respuesta del servidor.

        ServerSocket servidor = new ServerSocket(5000);
        Socket cliente;

        System.out.println("En espera de un cliente...");
        cliente = servidor.accept();

        System.out.println("Cliente conectado.");

        //CREO FLUJO DE ENTRADA DEL CLIENTE
        InputStream entrada = null;
        entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        // CREO FLUJO DE salida al CLIENTE
        OutputStream salida = null;
        salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        //leo mensaje del cliente

        System.out.println("Mensaje del cliente: "+flujoEntrada.readUTF());

        //envío el mensaje cambiado al cliente
        String cadena = flujoEntrada.readUTF().toUpperCase();
        flujoSalida.writeUTF("Este es el mensaje: "+cadena);
        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        servidor.close();
        cliente.close();

    }
}
