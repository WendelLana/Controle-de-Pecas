import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    //private static final AtomicInteger count = new AtomicInteger(0);

    public Server (String name) {
        System.out.println("Iniciando servidor "+ name);
        try {
            LocateRegistry.createRegistry(25565);
            InterfacePartRepository obj = new PartRepository(name);
            Naming.rebind("//localhost:25565/"+ name, obj);
        } catch (Exception e) {
            System.out.print("Erro: "+ e);
        }
    }
    public static void main(String[] args) {
        new Server(args[0]);
    }
}
