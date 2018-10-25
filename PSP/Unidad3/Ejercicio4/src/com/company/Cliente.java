package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;


public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket servidor = new Socket(InetAddress.getLocalHost(),5000);


        DataOutputStream mensaje;

//enviar mensaje al servidor.

        mensaje = new DataOutputStream(servidor.getOutputStream());
        mensaje.writeUTF("Este mensaje es lo que hay.");

        //recibir mensaje del servidor
        System.out.println("Esperando mensaje del servidor.");
        DataInputStream smsServidor=new DataInputStream(servidor.getInputStream());
        System.out.println("Mensaje traducido: "+smsServidor.readUTF());

        //cerramos conexiones

        mensaje.close();
        smsServidor.close();
        servidor.close();
    }
}
