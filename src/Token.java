/**
 * AŞAMA 2: Sözcüksel Analiz Birimleri
 */
public class Token {
    public enum Type {
        HAYVAN_EKLE, // 'hayvanEkle' komutu
        YEM_VER,     // 'yemVer' komutu
        SUT_SAG,     // 'sutSag' komutu
        HASAT_YAP,   // 'hasatYap' komutu
        STRING,      // "Inek" gibi metinler
        NUMBER,      // 10, 20 gibi sayılar
        SEMICOLON,   // ';' işareti
        EOF          // Kodun bittiğini belirten işaret
    }

    public Type type;
    public String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }
}
