package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        //el cliente necesita el socket servidor y el inetaddress direccion
        Socket servidor;
        InetAddress direccion = InetAddress.getLocalHost();

        //llamada al servidor a traves del puerto 5500


        DataOutputStream mensaje;
        DataInputStream entrada;
        //Cliente
        {

            try {
                servidor = new Socket(direccion, 5500); /*conectar a un servidor en localhost con puerto 5000*/
                //creamos el flujo de entrada por el que se recibiran  mensajes
                DataInputStream flujoEntrada = new DataInputStream(servidor.getInputStream());

                System.out.println("Recibiendo del server " + flujoEntrada.readUTF());

                //creamos el flujo de datos por el que se enviara un mensaje
                mensaje = new DataOutputStream(servidor.getOutputStream());
                //enviamos el mensaje
                mensaje.writeUTF("Saludos al server desde el cliente");
                //Mostramos el segundo mensaje del servidor
                System.out.println("Recibiendo del server " + flujoEntrada.readUTF());


                flujoEntrada.close();
                mensaje.close();
                servidor.close();


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


        }

    }
}
