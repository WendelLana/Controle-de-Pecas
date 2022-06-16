import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.HashMap;

public interface InterfacePartRepository extends Remote {

    public void addPart(String name, String desc, HashMap<Part, Integer> subcomponents) throws RemoteException;
    public HashSet<Part> listParts() throws RemoteException;
    public Part getPart(int code) throws RemoteException;
    public String getRepositoryName() throws RemoteException;
    //public void showPart() throws java.rmi.RemoteException;
    //public void clearList() throws java.rmi.RemoteException;
    //public void addSubPart(Part subPart) throws java.rmi.RemoteException;
}