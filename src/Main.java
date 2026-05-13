import java.util.List;

public class Main {
    public static void main(String[] args) {
String kaynakKod=
    "yemVer 10;\n"+
	"sutSag;\n"+
    "hasatYap;";
    
    	
        try {
            // AŞAMA 2: Sözcüksel Analiz (Değişken ismi 'kaynakKod' olarak güncellendi)
            Lexer lexer = new Lexer(kaynakKod);
            List<Token> tokens = lexer.tokenize();
            
            // AŞAMA 3: Sözdizimsel Analiz (AST Oluşturma)
            Parser parser = new Parser(tokens);
            List<ASTNode> ast = parser.parse();
            
            // AŞAMA 4: Çalıştırma (Evaluator)
            Evaluator eval = new Evaluator();
            eval.evaluate(ast);
            
        } catch (Exception e) {
            // Bir hata oluşursa burası çalışır
            System.err.println("\n[SİSTEM MESAJI]: " + e.getMessage());
        }
    }
}
