import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Part {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int code;
    private String name, description, repositoryName;
    private HashMap<Part, Integer> subcomponents;

    public Part (String name, String desc, HashMap subcomponents, String repName) {
        this.code = count.incrementAndGet();
        this.name = name;
        this.description = desc;
        this.subcomponents = subcomponents;
        this.repositoryName = repName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public HashMap<Part, Integer> getSubcomponents() {
        return subcomponents;
    }

    public void addSubcomponent(Part subPart, int quant) {
        subcomponents.put(subPart, quant);
    }

    public boolean isPrimitive() {
        return subcomponents.isEmpty();
    }
}
