import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.children = new HashMap<>();
        this.dead = new HashSet<>();
        
        this.children.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        
        this.children.get(parentName).add(childName);
       
        this.children.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
       
        this.dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        if (!dead.contains(current)) {
            order.add(current);
        }
    
        for (String child : children.get(current)) {
            dfs(child, order);
        }
    }
}