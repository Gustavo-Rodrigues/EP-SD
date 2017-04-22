package com.semantix;

import java.util.Map;
import java.util.HashMap;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class PartObject implements Part{

    private static final long serialVersionUID = 1L;

    public int cod = 0;
    public String name  = "";
    public String description = "";
    public Map<Part, Integer> subComponents = new HashMap<Part, Integer>();
    public String ServerName;

    //GETTERS

    public int getCod(){
        return this.cod;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Map<Part, Integer> getSubComponents(){
        return subComponents;
    }

    public String getServerName(){
        return this.ServerName;
    }


    //SETTERS

    public void setCod(int cod){
        this.cod = cod;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void addSubComponents(Map<Part, Integer> subComponents){
        this.subComponents.putAll(subComponents);
    }

    public void setServerName(String ServerName){
        this.ServerName = ServerName;
    }

}