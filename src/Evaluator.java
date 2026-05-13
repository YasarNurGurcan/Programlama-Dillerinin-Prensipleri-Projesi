import java.util.List;

/**
 * AŞAMA 4: Evaluator
 */
public class Evaluator {
    private FarmEnvironment env = new FarmEnvironment();

    public void evaluate(List<ASTNode> nodes) {
        for (ASTNode node : nodes) {
            node.execute(env);
        }
    }
}
