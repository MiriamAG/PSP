package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket ();
        System.out.println("Enviando petición al servidor.");

        //falta hacer la conexión al servidor, con un datagrampacket y mandandole un sms al servidor

        System.out.println("Escribe un mensaje al servidor: ");
        BufferedReader br = new BufferedReader(new InputStream())
                br.readLine();
        //ese brreadline hay que convertirlo a cadena de bytes con el datagrampacket

        DatagramPacket datorecibido = new DatagramPacket(new byte[1024], 1024);
        System.out.println("Recibiendo datos; ");
        socket.receive(datorecibido);
        socket.close();

    }
}
