package com.semantix;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import com.semantix.Part;
//import com.semantix.PartRepository;

public class Server extends UnicastRemoteObject implements Part , PartRepository {

//    private static final long serialVersionUID = 1L;

    //PART
    public int cod = 0;
    public String name  = "";
    public String description = "";
    public Map<Part, Integer> subComponents = new HashMap<Part, Integer>();

    //PART REPOSITORY
    public ArrayList<Part> parts = new ArrayList<Part>();
    public String connection = "";
    public String namePartsRepository = "";

    //SERVER
    public String nameServer = "";

    public Server() throws RemoteException {
        super();
    }

    ////////////
    //  PART  //
    ////////////


    //PART GETTERS
    @Override
    public int getCod() throws RemoteException {
        return this.cod;
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public String getDescription() throws RemoteException {
        return this.description;
    }


    //PART SETTERS
    @Override
    public void setCod(int cod) throws RemoteException {
        this.cod = cod;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public void setDescription(String description) throws RemoteException {
        this.description = description;
    }

    //PART ADDERS
    @Override
    public void addSubComponent(Map<Part, Integer> subComponents, Part part, int quantity){
        subComponents.put(part,quantity);
    }

    /////////////////////
    // PART REPOSITORY //
    /////////////////////

    //PART REPOSITORY GETTERS
    @Override
    public Part getPart(int cod){
        return null;
    }

    @Override
    public void addPart(Part part) throws RemoteException {
        parts.add(part);
    }

    @Override
    public Map<Part, Integer> getSubcomponents() throws RemoteException{
        return subComponents;
    }

//    @Override
//    public Part selectPart(int cod) throws RemoteException {
//        Iterator <AmountSubComponents> iterator = componentsPart.iterator();
//        AmountSubComponents auxSubPart = null;
//        while (iterator.hasNext()) {
//            auxSubPart = iterator.next();
//            if(cod == auxSubPart.getSubComponent().getCod()) {
//                break;
//            }
//        }
//        return auxSubPart.getSubComponent();
//    }


    @Override
    public void showParts() throws RemoteException{
        Iterator <Part> iterator = parts.iterator();
        Part auxPart = null;
        System.out.println("------ Lista de todas as Parts ------");
        while (iterator.hasNext()) {
            auxPart = iterator.next();
            System.out.printf("Codigo: %i\n", auxPart.getCod());
            System.out.printf("Nome: %s\n", auxPart.getName());
            System.out.printf("Descricao: %i\n", auxPart.getDescription());
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }


    @Override
    public String getConnection() throws RemoteException {
        return this.connection;
    }

    @Override
    public String getNamePartRepository() throws RemoteException {
        return this.namePartsRepository;
    }

    @Override
    public ArrayList<Part> getParts() throws RemoteException {
        return this.parts;
    }

    @Override
    public void setConnection(String conn) throws RemoteException {
        this.connection = conn;
    }

    @Override
    public void setNamePartRepository(String name) throws RemoteException {
        this.namePartsRepository = name;
    }



}