package com.company;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws UnknownHostException {

        /*Crea un programa para trabajar con la clase InetAddress. Debemos obtener la
        dirección IP de la maquina local en la que se ejecuta el programa. Obtén a través del
        método getAllByName() todas las direcciones IP asignadas a la maquina representada
        por www.google.es. En este mismo programa prueba todos los métodos de esta clase
        vistos en clase.*/

        InetAddress[] direccion = InetAddress.getAllByName("amazon.es");//te devuelve todas las ips de amazon

        for ( int x= 0;x< direccion.length; x++ ){

        System.out.println(direccion[x]);
        }

        InetAddress dir = InetAddress.getLocalHost();//te devuelve la ip local
        System.out.println("Este es el local: "+dir);

        InetAddress ulti = InetAddress.getByName("8.8.8.8");//te devuelve el nombre de la ip
        System.out.println("Este es el get by name:"+ ulti);
    }
}
