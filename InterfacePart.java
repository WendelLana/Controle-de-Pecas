import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface InterfacePart extends Remote {    

    public int getCode() throws RemoteException;
    public void setCode(int code) throws RemoteException;
    public String getName() throws RemoteException;
    public void setName(String name) throws RemoteException;
    public String getDescription() throws RemoteException;
    public void setDescription(String desc) throws RemoteException;
    public String getRepositoryName() throws RemoteException;
    public HashMap<InterfacePart, Integer> getSubcomponents() throws RemoteException;
    public void addSubcomponent(InterfacePart subPart, int quant) throws RemoteException;
    public boolean isPrimitive() throws RemoteException;
}
