import java.io.Console;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

public class Client {
    public InterfacePartRepository currentRepository;
    public InterfacePart currentPart;
    public HashMap<InterfacePart, Integer> subcomponents;

    public Client() {
        currentRepository = null;
        currentPart = null;
        subcomponents = new HashMap<InterfacePart, Integer>();
    }

    public void init() {
        int opt = 0;
        do {
            System.out.println("\n\n### Gerenciador de peças ###");
            System.out.println("\n =========================");
            System.out.println("   |   1 - Abrir repositório      |");
            System.out.println("   |   2 - Listar peças           |");
            System.out.println("   |   3 - Buscar por peça        |");
            System.out.println("   |   4 - Mostrar peça           |");
            System.out.println("   |   5 - Limpar lista subpeças  |");
            System.out.println("   |   6 - Adicionar peça à lista |");
            System.out.println("   |   7 - Adicionar peça ao repo |");
            System.out.println("   |   0 - Sair                   |");
            System.out.println(" =========================\n");
            if (currentRepository != null) {
                System.out.println("Repositório atual: " + currentRepository.getRepositoryName());
            }
            Console scan = System.console();
            opt = Integer.parseInt(scan.readLine());
            switch (opt) {
                case 1:
                    try {
                        System.out.println("Escreva o nome do repositório: ");
                        String repName = scan.readLine();
                        currentRepository = (InterfacePartRepository) Naming.lookup("//localhost/" + repName);
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
                    break;
                case 2:
                    currentRepository.listParts();
                    break;
                case 3:
                    System.out.println("Digite o código da peça que deseja buscar: ");
                    int code = Integer.parseInt(scan.readLine());
                    currentPart = currentRepository.getPart(code);
                    break;
                case 4:
                    break;
                case 5:
                    subcomponents.clear();
                    break;
                case 6:
                    System.out.println("Digite a quantidade da peça "+ currentPart.getName() +" para adicionar: ");
                    int quant = Integer.parseInt(scan.readLine());
                    subcomponents.put(currentPart, quant);
                    break;
                case 7:
                    break;
            }
        } while (opt != 0);
    }

    public static void main(String[] args) {
        Client newCliente = new Client();
        newCliente.init();
    }
}
