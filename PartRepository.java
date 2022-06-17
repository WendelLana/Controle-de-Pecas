import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.HashMap;

public class PartRepository extends UnicastRemoteObject implements InterfacePartRepository {
    private HashSet<InterfacePart> repository;
    private String repositoryName;
    
    public PartRepository(String name) throws RemoteException {
        this.repository = new HashSet<InterfacePart>();
        this.repositoryName = name;
    }

    public String getRepositoryName() throws RemoteException {
        return repositoryName;
    }

    public int countRepositoryParts() throws RemoteException {
        return repository.size();
    }

    public void addPart(String name, String desc, HashMap<InterfacePart, Integer> subcomponents) throws RemoteException {
        InterfacePart newPart = new Part(name, desc, subcomponents, repositoryName);
        repository.add(newPart);
    }

    public HashSet<InterfacePart> listParts() throws RemoteException {
        return repository;
    }

    public InterfacePart getPart(int code) throws RemoteException {
        for (InterfacePart part : repository) {
            if (part.getCode() == code) {
                return part;
            }
        }
        return null;
    }
}
