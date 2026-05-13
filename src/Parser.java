import java.util.ArrayList;
import java.util.List;

/**
 * AŞAMA 3: Sözdizimsel Analiz (Parser)
 */
public class Parser {
    private List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) { this.tokens = tokens; }

    public List<ASTNode> parse() {
        List<ASTNode> nodes = new ArrayList<>();
        while (!isAtEnd()) {
            nodes.add(statement());
        }

        System.out.println("\n[AŞAMA 3] FARMLANG SOYUT SÖZDİZİMİ AĞACI (AST):");
        System.out.println("FARM_ROOT");
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).toTreeString("    ", i == nodes.size() - 1));
        }
        System.out.println("----------------------------------------------\n");
        return nodes;
    }

    private ASTNode statement() {
        if (match(Token.Type.HAYVAN_EKLE)) {
            Token val = consume(Token.Type.STRING, "Hayvan ismi bekleniyor!");
            consume(Token.Type.SEMICOLON, "';' eksik!");
            return new AddAnimalNode(val.value);
        } else if (match(Token.Type.YEM_VER)) {
            Token val = consume(Token.Type.NUMBER, "Sayı bekleniyor!");
            consume(Token.Type.SEMICOLON, "';' eksik!");
            return new FeedNode(Integer.parseInt(val.value));
        } else if (match(Token.Type.SUT_SAG)) {
            consume(Token.Type.SEMICOLON, "';' eksik!");
            return new MilkNode();
        } else if (match(Token.Type.HASAT_YAP)) {
            consume(Token.Type.SEMICOLON, "';' eksik!");
            return new HarvestNode();
        }
        throw new RuntimeException("Sözdizimi hatası!");
    }

    private boolean match(Token.Type t) { if(check(t)){current++; return true;} return false; }
    private boolean check(Token.Type t) { return !isAtEnd() && peek().type == t; }
    private Token consume(Token.Type t, String m) { if(check(t)) return tokens.get(current++); throw new RuntimeException(m); }
    private Token peek() { return tokens.get(current); }
    private boolean isAtEnd() { return peek().type == Token.Type.EOF; }
}
