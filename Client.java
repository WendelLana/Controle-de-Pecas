import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public PartRepository currentRepository;
    public Part currentPart;
    public HashMap<Part, Integer> subcomponents;
    public static void main(String[] args) {
        int opt = 0;
        do {
            System.out.println("\n\n### Gerenciador de Salas para o Marcador de Reuniões ###");
            System.out.println("\n                  =========================");
            System.out.println("                  |   1 - Abrir repositório      |");
            System.out.println("                  |   2 - Listar peças           |");
            System.out.println("                  |   3 - Buscar por peça        |");
            System.out.println("                  |   4 - Mostrar peça           |");
            System.out.println("                  |   5 - Limpar lista subpeças  |");
            System.out.println("                  |   6 - Adicionar peça à lista |");
            System.out.println("                  |   7 - Adicionar peça ao repositório |");
            System.out.println("                  |   0 - Sair       |");
            System.out.println("                  =========================\n");
            Console scan = System.console();
            opt = Integer.parseInt(scan.readLine());
            switch (opt) {
                case 1:
                break;
            }
        } while (opt != 0);
        try {
            InterfacePartRepository rep = (InterfacePartRepository) Naming.lookup("//localhost/" + "repository0");
            
        } catch (MalformedURLException murle) {
            System.out.println("MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println("NotBoundException");
            System.out.println(nbe);
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e);
        }
    }
}
