package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.Time;
import java.util.TimeZone;

public class Servidor {

    public static void main(String[] args) throws IOException {
	// Cread una aplicación cliente/servidor, en la que el servidor proporciona la hora y el día
        //a los clientes que lo soliciten, ademas de información, sobre que dir IP y puerto tiene
        //el cliente. El programa cliente realizará una petición al servidor y esperará la
        //respuesta. Para ello utiliza conexiones UDP.


        int puerto = 5000;
        byte msg[]=new byte[1024];
        //este es el que usa la conexion
        DatagramSocket servidor = new DatagramSocket(5000);


        System.out.println("Servidor activo:");

        //creamos el mensaje en bytes y el tamaño que va a tener ese mensaje
        DatagramPacket conexion = new DatagramPacket(new byte[1024],1024);

        while (true){
            //servidor escucha peticion del cliente
            servidor.receive(conexion);
            System.out.println("Se ha establecido una conexión con el servidor.\n");
            System.out.println("Proveniente de la IP: "+conexion.getAddress());
            System.out.println("Con el puerto: "+conexion.getPort());

            //queremos enviarle ese mensjae de vuelta al cliente junto con la hora
            String mensaje = new String ("Conexión establecida con el cliente "+conexion.getAddress()+" con el puerto "+conexion.getPort()+" a");
            msg =mensaje.getBytes();

            //para enviar el mensaje hay que hacerlo a través de un paquete:
            DatagramPacket paquete = new DatagramPacket(msg, msg.length,conexion.getAddress(),conexion.getPort());

            //finalmente se envía el paquete

            servidor.send(paquete);
            servidor.close();

        }






    }
}
