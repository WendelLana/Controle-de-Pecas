import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.HashMap;

public class PartRepository extends UnicastRemoteObject implements InterfacePartRepository {
    private HashSet<Part> repository;
    private String repositoryName;
    
    public PartRepository(String name) throws RemoteException {
        this.repository = new HashSet<Part>();
        this.repositoryName = name;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public int countRepositoryParts() {
        return repository.size();
    }

    public void addPart(String name, String desc, HashMap<Part, Integer> subcomponents) throws RemoteException {
        Part newPart = new Part(name, desc, subcomponents, repositoryName);
        repository.add(newPart);
    }

    public HashSet<Part> listParts() throws RemoteException {
        System.out.println("Peças contidas no repositório "+ repositoryName);
        System.out.printf("\n%6s %15s %20s", "Código", "Nome", "Descrição");
        for (Part part : repository) {
            System.out.printf("\n%6s %15s %20s", part.getCode(), part.getName(), part.getDescription());
        }
        return repository;
    }

    public Part getPart(int code) throws RemoteException {        
        for (Part part : repository) {
            if (part.getCode() == code) {
                return part;
            }
        }
        return null;
    }
}
