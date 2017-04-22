package com.semantix;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public interface PartRepository extends Remote{


    //GETTERS
    //public Part getPart(int cod) throws RemoteException;
    public String getServerName() throws RemoteException;
    public ArrayList<Part> listParts() throws RemoteException;


    //ADDERS
    public int addPart(String name, String description, Map<Part, Integer> subComponents) throws RemoteException;
}