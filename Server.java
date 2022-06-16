import java.rmi.Naming;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static final AtomicInteger count = new AtomicInteger(0);

    public Server () {
        try {
            InterfacePartRepository obj = new PartRepository();
            Naming.rebind("//localhost/repository"+ count.incrementAndGet(), obj);
        } catch (Exception e) {
            System.out.print("Erro: "+ e);
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
