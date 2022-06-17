import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Part extends UnicastRemoteObject implements InterfacePart {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int code;
    private String name, description, repositoryName;
    private HashMap<InterfacePart, Integer> subcomponents;

    public Part (String name, String desc, HashMap<InterfacePart, Integer> subcomponents, String repName) throws RemoteException {
        this.code = count.incrementAndGet();
        this.name = name;
        this.description = desc;
        this.subcomponents.putAll(subcomponents);
        this.repositoryName = repName;
    }

    public int getCode() throws RemoteException {
        return code;
    }

    public void setCode(int code) throws RemoteException {
        this.code = code;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public String getDescription() throws RemoteException {
        return description;
    }

    public void setDescription(String desc) throws RemoteException {
        this.description = desc;
    }

    public String getRepositoryName() throws RemoteException {
        return repositoryName;
    }

    public HashMap<InterfacePart, Integer> getSubcomponents() throws RemoteException {
        return subcomponents;
    }

    public void addSubcomponent(InterfacePart subPart, int quant) throws RemoteException {
        subcomponents.put(subPart, quant);
    }

    public boolean isPrimitive() throws RemoteException {
        return subcomponents.isEmpty();
    }
}
