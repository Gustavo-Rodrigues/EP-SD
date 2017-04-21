package com.semantix;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PartRepository extends Remote{

    public void addPart(Part part) throws RemoteException;
    public Part getPart(int cod) throws RemoteException;
    public void showParts() throws RemoteException;

    public String getConnection() throws RemoteException;
    public String getNamePartRepository() throws RemoteException;
    public ArrayList<Part> getParts() throws RemoteException;

    public void setConnection(String conn) throws RemoteException;
    public void setNamePartRepository(String name) throws RemoteException;
}

