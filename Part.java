import java.util.HashMap;

public class Part {
    private static final AtomicInteger count = new AtomicInteger(0);
    public int code;
    public String name, description;
    public HashMap<Part, Integer> subcomponents;

    public Part (String name, String desc, HashMap subcomponents) {
        this.code = count.incrementAndGet();
        this.name = name;
        this.description = desc;
        this.subcomponents = subcomponents;
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

    public HashMap<Part, Integer> getSubcomponents() {
        return subcomponents;
    }

    public void addSubcomponent(Part subPart, int quant) {
        subcomponents.put(subPart, quant);
    }

    public void clearSubcomponents() {
        subcomponents.clear();
    }
}
