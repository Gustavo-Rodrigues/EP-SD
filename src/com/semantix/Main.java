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
public class Main {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        String serverName = args[0];
        try {
            Server server = new Server(serverName);
            //THIS MIGHT NOT WORK
            PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(server, 0);
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("teste", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
//            e.printStackTrace();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Servidor criado as: "+dateFormat.format(date));
    }
}
