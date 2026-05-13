import java.util.ArrayList;
import java.util.List;

/**
 * AŞAMA 2: Sözcüksel Analizör
 */
public class Lexer {
    private String input;
    private int pos = 0;

    public Lexer(String input) { this.input = input; }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (pos < input.length()) {
            char ch = input.charAt(pos);

            if (Character.isWhitespace(ch)) { pos++; continue; }

            if (ch == ';') {
                tokens.add(new Token(Token.Type.SEMICOLON, ";"));
                pos++;
            }
            else if (ch == '"') {
                StringBuilder sb = new StringBuilder(); pos++;
                while (pos < input.length() && input.charAt(pos) != '"') {
                    sb.append(input.charAt(pos)); pos++;
                }
                pos++; tokens.add(new Token(Token.Type.STRING, sb.toString()));
            }
            else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
                    sb.append(input.charAt(pos)); pos++;
                }
                tokens.add(new Token(Token.Type.NUMBER, sb.toString()));
            }
            else if (Character.isLetter(ch)) {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && Character.isLetter(input.charAt(pos))) {
                    sb.append(input.charAt(pos)); pos++;
                }
                String word = sb.toString();
                switch (word) {
                    case "hayvanEkle": tokens.add(new Token(Token.Type.HAYVAN_EKLE, word)); break;
                    case "yemVer": tokens.add(new Token(Token.Type.YEM_VER, word)); break;
                    case "sutSag": tokens.add(new Token(Token.Type.SUT_SAG, word)); break;
                    case "hasatYap": tokens.add(new Token(Token.Type.HASAT_YAP, word)); break;
                    default: throw new RuntimeException("Bilinmeyen komut: " + word);
                }
            } else { pos++; }
        }
        tokens.add(new Token(Token.Type.EOF, ""));
        return tokens;
    }
}
