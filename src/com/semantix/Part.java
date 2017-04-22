package com.semantix;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.io.Serializable;

public interface Part extends Remote, Serializable{

    //ADDERS
    public void addSubComponents(Map<Part, Integer> subComponents) throws RemoteException;

    //GETTERS
    public int getCod() throws RemoteException;
    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public Map<Part, Integer> getSubComponents() throws RemoteException;
    public String getServerName() throws RemoteException;

    //SETTERS
    public void setCod(int cod) throws RemoteException;
    public void setName(String name) throws RemoteException;
    public void setDescription(String description) throws RemoteException;
    public void setServerName(String serverName) throws RemoteException;
}