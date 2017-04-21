package com.semantix;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Part extends Remote {

    //getters
    public int getCod() throws RemoteException;
    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public Map<Part, Integer> getSubcomponents() throws RemoteException;

    //setters
    public void setCod(int cod) throws RemoteException;
    public void setName(String name) throws RemoteException;
    public void setDescription(String description) throws RemoteException;
    public void setComponents() throws RemoteException;

}
