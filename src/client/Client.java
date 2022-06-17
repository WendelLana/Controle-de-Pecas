package client;

import java.io.Console;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

import interfaces.*;

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
        try {
            do {
                System.out.println("### Menu do Gerenciador de Pecas ###");
                System.out.println(" =========================");
                System.out.println("   |   1 - Abrir repositorio      |");
                System.out.println("   |   2 - Listar pecas           |");
                System.out.println("   |   3 - Buscar por peca        |");
                System.out.println("   |   4 - Mostrar peca           |");
                System.out.println("   |   5 - Limpar lista subpecas  |");
                System.out.println("   |   6 - Adicionar peca a lista |");
                System.out.println("   |   7 - Adicionar peca ao repo |");
                System.out.println("   |   0 - Sair                   |");
                System.out.println(" =========================");
                if (currentRepository != null) {
                    System.out.println("Repositorio atual: " + currentRepository.getRepositoryName());
                }
                Console scan = System.console();
                opt = Integer.parseInt(scan.readLine());
                switch (opt) {
                    case 1:
                        System.out.println("Escreva o nome do repositorio: ");
                        String repName = scan.readLine();
                        currentRepository = (InterfacePartRepository) Naming.lookup("//localhost:25565/" + repName);
                        break;
                    case 2:
                        if (currentRepository == null) {
                            System.out.println("Nenhum repositorio foi aberto");
                            break;
                        }
                        System.out.printf("\n%-6s %-15s %-20s", "Codigo", "Nome", "Descricao");
                        for (InterfacePart part : currentRepository.listParts()) {
                            System.out.printf("\n%-6s %-15s %-20s", part.getCode(), part.getName(), part.getDescription());
                        }
                        System.out.println("\nTotal: "+ currentRepository.countRepositoryParts());
                        break;
                    case 3:
                        if (currentRepository == null) {
                            System.out.println("Nenhum repositorio foi aberto");
                            break;
                        }
                        System.out.println("Digite o codigo da peca que deseja buscar: ");
                        int code = Integer.parseInt(scan.readLine());
                        currentPart = (InterfacePart) currentRepository.getPart(code);
                        break;
                    case 4:
                        if (currentPart == null) {
                            System.out.println("Nenhuma peca foi selecionada do repositorio");
                            break;
                        }
                        System.out.println("Nome da peca: "+ currentPart.getName());
                        System.out.println("Descricao: "+ currentPart.getDescription());
                        System.out.println("Repositorio: "+ currentPart.getRepositoryName());
                        if (currentPart.isPrimitive()) {
                             System.out.println("Primitiva: Sim");
                        } else {
                            System.out.println("Primitiva: Nao");
                            System.out.println("Lista de subcomponentes: ");
                            System.out.printf("\n%-25s %-6s", "Nome", "Quant.");
                            for (Map.Entry<InterfacePart, Integer> subcomponent : currentPart.getSubComponents().entrySet()) {
                                System.out.printf("\n%-25s %-6s", subcomponent.getKey().getName(), subcomponent.getValue());
                            }
                            System.out.println("\nTotal: "+ currentPart.getTotalSubComponents());
                        }
                        break;
                    case 5:
                        subcomponents.clear();
                        break;
                    case 6:
                        if (currentPart == null) {
                            System.out.println("Nenhuma peca foi selecionada do repositorio");
                            break;
                        }
                        System.out.println("Digite a quantidade da peca " + currentPart.getName() + " para adicionar: ");
                        int quant = Integer.parseInt(scan.readLine());
                        subcomponents.put(currentPart, quant);
                        break;
                    case 7:
                        if (currentRepository == null) {
                            System.out.println("Nenhum repositorio foi aberto");
                            break;
                        }
                        System.out.println("Coloque o nome da peca: ");
                        String partName = scan.readLine();
                        System.out.println("Coloque uma descricao da peca: ");
                        String partDesc = scan.readLine();
                        currentRepository.addPart(partName, partDesc, subcomponents);
                        break;
                }
            } while (opt != 0);
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

    public static void main(String[] args) {
        Client newCliente = new Client();
        newCliente.init();
    }
}
