import java.util.Set;
import java.rmi.*;

public class PartRepository extends java.rmi.server.UnicastRemoteObject implements InterfacePartRepository {
    public Set<Part> repository;
    
    public PartRepository() throws RemoteException {
        this.repository = new Set<Part>();
    }

    public void addPart(String name, String desc, HashMap<Part, Integer> subcomponents) throws RemoteException {
        Part newPart = new Part(name, desc, subcomponents);
        repository.add(newPart);
    }

    public Set<Part> listParts() throws RemoteException {
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
