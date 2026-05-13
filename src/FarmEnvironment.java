/**
 * AŞAMA 4: Sembol Tablosu & Çalışma Ortamı
 */
public class FarmEnvironment {
    private String currentAnimal = "";
    private int foodLevel = 0;
    private boolean isMilked = false;

    public void addAnimal(String name) { this.currentAnimal = name; }
    public void feed(int amount) { this.foodLevel += amount; }
    public void milk() { this.isMilked = true; }

    public void harvest() {
        if (currentAnimal.isEmpty()) throw new RuntimeException("Anlamsal Hata: Önce hayvan eklenmeli!");

        System.out.println(">>> HASAT RAPORU <<<");
        System.out.println("Hayvan: " + currentAnimal);
        System.out.println("Yem Miktarı: " + foodLevel);
        System.out.println("Sağım Durumu: " + (isMilked ? "Tamamlandı" : "Yapılmadı"));
        System.out.println("Hasat başarıyla sonuçlandı! 🌾\n");
    }
}
