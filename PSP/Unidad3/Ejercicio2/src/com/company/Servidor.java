package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
	/*Implementa una aplicación cliente-servidor donde el servidor salude a cada uno de los
        clientes que se conectan. Como máximo atenderá a tres clientes. En este ejemplo tan
        solo se devuelve por parte del servidor un saludo indicándole el numero de cliente que
        es. El servidor estará escuchando en el puerto 5000.*/

        Socket cliente =null;
        ServerSocket servidor = null;

        int numeroCliente = 1;
        try {
             servidor= new ServerSocket(5000);//asignamos el numero servidor
        } catch (IOException e) {
            e.printStackTrace();
        }

    do {
        try {

            cliente = servidor.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream ps = null;
        try {
            ps = new PrintStream(cliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ps.println("Usted es mi cliente "+ numeroCliente);
        numeroCliente++;

    }while (numeroCliente<4);
        try {
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
