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

    private static final long serialVersionUID = 1L;

    //variaveis de Part
    public int codPart = 0;
    public String namePart  = "";
    public String describePart = "";
    public Map<Part, Integer> subComponents = new HashMap<Part, Integer>();
//    public ArrayList<AmountSubComponents> componentsPart = new ArrayList<AmountSubComponents>();

    //variaveis de PartRepository
    public ArrayList<Part> partsList = new ArrayList<Part>();
    public String connection = "";
    public String namePR = "";

    //variaveis do Servidor
    public String nameServer = "";


    public Server() throws RemoteException {
        super();
    }

    ////////////
    //  PART  //
    ////////////

    @Override
    public int getCod() throws RemoteException {
        return this.codPart;
    }

    @Override
    public String getName() throws RemoteException {
        return this.namePart;
    }

    @Override
    public String getDescription() throws RemoteException {
        return this.describePart;
    }


    @Override
    public void setCod(int cod) throws RemoteException {
        this.codPart = cod;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.namePart = name;
    }

    @Override
    public void setDescription(String describe) throws RemoteException {
        this.describePart = describe;
    }

    @Override
    public void setComponents() throws RemoteException {
        //this.componentsPart.clear();
    }

    @Override
    public void addPart(Part part) throws RemoteException {
        partsList.add(part);
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
    public Part getPart(int cod){
        return null;
    }

    @Override
    public void showParts() throws RemoteException{
        Iterator <Part> iterator = partsList.iterator();
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
        return this.namePR;
    }

    @Override
    public ArrayList<Part> getParts() throws RemoteException {
        return this.partsList;
    }

    @Override
    public void setConnection(String conn) throws RemoteException {
        this.connection = conn;
    }

    @Override
    public void setNamePartRepository(String name) throws RemoteException {
        this.namePR = name;
    }



}