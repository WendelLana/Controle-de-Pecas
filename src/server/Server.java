package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    //private static Registry registry;

    public Server (String name, String strPort) {
        System.out.println("Iniciando servidor "+ name +"...");
        try {
            int port = Integer.parseInt(strPort);
            LocateRegistry.createRegistry(port);
            PartRepository obj = new PartRepository(name);
            Naming.rebind("//localhost:"+ port +"/"+ name, obj);
            System.out.println("Servidor iniciado e rodando!");
        } catch (Exception e) {
            System.out.print("Erro: "+ e);
        }
    }
    public static void main(String[] args) {
        new Server(args[0], args[1]);
    }
}

