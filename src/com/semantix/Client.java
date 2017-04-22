package com.semantix;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Client {

    private static String command;
    private static Part currentPart;
    private static PartRepository currentRepository;
    private static Map<Part, Integer> subComponents = new HashMap<Part, Integer>();

    private Client() {}

    public static void main(String[] args) {

        /*String host = (args.length < 1) ? null : args[0];
		int port = (args.length == 2) ? 0 : Integer.parseInt(args[1]);*/

        String host;
        int port;
        Registry registry;
        ArrayList<Part> Parts;

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Especifique o nome do host do registro (valor padrao: localhost) ");
        command = sc1.nextLine();
        host = (command.equals("")) ? null : command;
        command = "";
        System.out.println("Especifique a porta de acesso ao registro (valor padrao: 1099) ");
        command = sc1.nextLine();
        command = (command.equals("")) ? "1099" : command;
        port = Integer.parseInt(command);

        try {

            if (port != 0)
                registry = LocateRegistry.getRegistry(host, port);
            else
                registry = LocateRegistry.getRegistry(host);

            System.out.println ("Conexão estabelecida com sucesso. O que você deseja fazer agora?");
            System.out.println();

            command = sc1.nextLine();

            while (!(command.toLowerCase().equals("quit"))){

                String[] parts = command.split(" ");

                switch (parts[0].toLowerCase()) {

                    case "bind":
                        currentRepository = (PartRepository) registry.lookup(parts[1]);
                        System.out.println();
                        System.out.println("Conexão estabelecida com sucesso");
                        System.out.println("Repositório: " + currentRepository.getServerName());
                        System.out.println();
                        break;

                    case "listp":
                        if (currentRepository == null){
                            System.out.println("Por favor, conecte-se antes a um repositório.");
                            break;
                        }

                        else{
                            Parts = currentRepository.listParts();
                            for (Part currPart: Parts) {
                                System.out.println("Lista de partes");
                                System.out.println();
                                System.out.println("Codigo:"+currPart.getCod());
                                System.out.println("Nome: "+currPart.getName());
                                System.out.println("descricao: "+currPart.getDescription());
                                System.out.println();
                            }
                        }

                        break;

                    case "addp":
                        System.out.println("Escreva o nome da peça");
                        command = sc1.nextLine();
                        String nomeDaPeca = command;
                        System.out.println("Escreva a descrição da peça");
                        command = sc1.nextLine();
                        String descricaoDaPeca = command;
                        int codigoDaPeca = currentRepository.addPart(nomeDaPeca,descricaoDaPeca,subComponents);
                        System.out.println("Peca adicionada com as seguintes informacoes:");
                        System.out.println();
                        System.out.println("Codigo: " + codigoDaPeca);
                        System.out.println("Nome: " + nomeDaPeca);
                        System.out.println("Descricao: " + descricaoDaPeca);
                        System.out.println();
                        break;

                    default:
                        System.out.println("Por favor, insira um comando válido.");
                }
                command = sc1.nextLine();
            }

            System.out.println("Conexão encerrada.");
            System.out.println();

          /*  String response = stub.sayHello();
            System.out.println("response: " + response);*/

        }

        catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
			/*System.err.println("Por favor, insira um host válido para nos conectarmos ao RMI registry. Se preferir, deixe este campo vazio e nos conectaremos ao seu próprio localhost");*/
        }
    }
}



