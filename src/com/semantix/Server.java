package com.semantix;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.semantix.Part;
import com.semantix.PartRepository;
import java.util.LinkedList;

public class Server implements PartRepository {

    //private static final long serialVersionUID = 1L;

    public ArrayList<Part> parts = new ArrayList<Part>();
    public String serverName = "";

    //IF YOU HAVE TIME, SEE IT
    int contador = 0;

    public Server(String serverName) {
        this.serverName = serverName;
    }

    //GETTERS
    public String getServerName(){
        return this.serverName;
    }


    public ArrayList <Part> listParts() throws RemoteException{

        return parts;

    }

    public int addPart(String name, String description, Map<Part, Integer> subComponents) throws RemoteException{

        Part part = new PartObject();
        part.setName(name);
        part.setDescription(description);
        part.setServerName(this.serverName);
        part.addSubComponents(subComponents);
        part.setCod(contador);
        contador++;

        parts.add(part);

        return part.getCod();
    }



}