import java.rmi.Naming;

public class Server {
    //private static final AtomicInteger count = new AtomicInteger(0);

    public Server (String name) {
        System.out.println("Iniciando servidor "+ name);
        try {
            InterfacePartRepository obj = new PartRepository(name);
            Naming.rebind("//localhost/"+ name, obj);
        } catch (Exception e) {
            System.out.print("Erro: "+ e);
        }
    }
    public static void main(String[] args) {
        new Server(args[0]);
    }
}
