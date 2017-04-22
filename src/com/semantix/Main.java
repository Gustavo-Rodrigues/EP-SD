package com.semantix;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.semantix.PartRepository;
import com.semantix.Part;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        String serverName;
        int port;
        String currentCommand = "";

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Especifique o nome do servidor (valor padrao: \"Default\") ");
        currentCommand = sc1.nextLine();
        serverName = (currentCommand.equals("")) ? "Default" : currentCommand;
        currentCommand = "";
        System.out.println("Especifique a porta de acesso ao registro (valor padrao: 1099) ");
        currentCommand = sc1.nextLine();
        currentCommand = (currentCommand.equals("")) ? "1099" : currentCommand;
        port = Integer.parseInt(currentCommand);

        try {
            Server server = new Server(serverName);
            PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(server, 0);
            LocateRegistry.createRegistry(port);
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(serverName, stub);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println("Servidor criado as: "+dateFormat.format(date));
            sc1.close();
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
//            e.printStackTrace();
        }


    }
}