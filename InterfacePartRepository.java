import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.HashMap;

public interface InterfacePartRepository extends Remote {
    //public void showPart() throws java.rmi.RemoteException;
    //public void clearList() throws java.rmi.RemoteException;
    //public void addSubPart(Part subPart) throws java.rmi.RemoteException;
    public String getRepositoryName() throws RemoteException;
    public int countRepositoryParts() throws RemoteException;
    public void addPart(String name, String desc, HashMap<InterfacePart, Integer> subcomponents) throws RemoteException;
    public HashSet<InterfacePart> listParts() throws RemoteException;
    public InterfacePart getPart(int code) throws RemoteException;
}