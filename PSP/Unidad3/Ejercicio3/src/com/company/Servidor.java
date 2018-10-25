package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        // Crea un servidor que escuche el puerto 5500, cuando un cliente se conecta este le
        //envía un mensaje de confirmación al cliente, luego el cliente al enviar su primer
        //mensaje, el servidor envía un segundo mensaje y se cierra la conexión.

        ServerSocket servidor;
        Socket cliente;


        //SERVIDOR
        {


            try {
                servidor = new ServerSocket(5500);/* crea socket servidor que escuchara en puerto 5500*/
                cliente = new Socket();
                System.out.println("Esperando una conexión:");
                cliente = servidor.accept();

                //Inicia el socket, ahora esta esperando una conexión por parte del cliente
                System.out.println("Un cliente se ha conectado.");
//                CREO FLUJO DE ENTRADA DEL CLIENTE
                InputStream entrada = null;
                entrada = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                // CREO FLUJO DE salida al CLIENTE
                OutputStream salida = null;
                salida = cliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                //Enviamos mensaje al cliente
                flujoSalida.writeUTF("Conexion aceptada");


//EL CLIENTE ME ENVIA UN MENSAJE

                System.out.println("Recibiendo del cliente  " + flujoEntrada.readUTF());

//
//ENVIO SALUDO AL CLIENTE
                flujoSalida.writeUTF("saludos al cliente del server");
//CERRAMOS
                entrada.close();
                flujoEntrada.close();
                salida.close();
                flujoSalida.close();
                servidor.close();
                cliente.close();

            } catch (Exception e) {


                System.out.println("Error: " + e.getMessage());

            }

        }
    }
}
