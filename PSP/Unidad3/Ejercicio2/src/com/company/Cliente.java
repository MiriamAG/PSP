package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {

        InetAddress direccion =null;
        Socket servidor = null;
        try {
             direccion = InetAddress.getLocalHost();//la ip que desea hacer la consulta
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            servidor = new Socket(direccion, 5000); //conexion con el servidor
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader( new
                    InputStreamReader( servidor.getInputStream() ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
