/**
 * AŞAMA 3 & 4: AST Düğümleri
 */
abstract class ASTNode {
    abstract void execute(FarmEnvironment env);
    abstract String toTreeString(String prefix, boolean isLast);
}

class AddAnimalNode extends ASTNode {
    String name;
    AddAnimalNode(String name) { this.name = name; }
    void execute(FarmEnvironment env) { env.addAnimal(name); }
    @Override String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[AddAnimal] ➔ \"" + name + "\"\n";
    }
}

class FeedNode extends ASTNode {
    int amount;
    FeedNode(int amount) { this.amount = amount; }
    void execute(FarmEnvironment env) { env.feed(amount); }
    @Override String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[Feed] ➔ Miktar: " + amount + "\n";
    }
}

class MilkNode extends ASTNode {
    void execute(FarmEnvironment env) { env.milk(); }
    @Override String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[Milk] ➔ Süt Sağımı\n";
    }
}

class HarvestNode extends ASTNode {
    void execute(FarmEnvironment env) { env.harvest(); }
    @Override String toTreeString(String prefix, boolean isLast) {
        return prefix + (isLast ? "└── " : "├── ") + "[Harvest] ➔ SONUÇ: HASAT YAP\n";
    }
}
