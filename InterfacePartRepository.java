import java.rmi.*;
import java.util.Set;

public interface InterfacePartRepository extends Remote {

    public void addPart(String name, String desc, Map<Part, Integer> subcomponents) throws RemoteException;
    public Set<Part> listParts() throws RemoteException;
    public Part getPart(int code) throws RemoteException;
    //public void showPart() throws java.rmi.RemoteException;
    //public void clearList() throws java.rmi.RemoteException;
    //public void addSubPart(Part subPart) throws java.rmi.RemoteException;
}
