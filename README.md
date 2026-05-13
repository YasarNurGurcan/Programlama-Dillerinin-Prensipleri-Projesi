FarmLang, bir çiftlikteki günlük operasyonları (hayvan yönetimi, besleme, hasat) modelleyen, Java diliyle geliştirilmiş bir Yorumlayıcı (Interpreter) projesidir. Bu proje; metin tabanlı komutları alarak onları anlamlı işlemlere dönüştüren, akademik standartlara uygun bir derleyici mimarisine sahiptir.

Dilin Özellikleri
FarmLang, bir programlama dilinin temel yapı taşlarını pratik bir uygulama üzerinde göstermek amacıyla tasarlanmıştır:

Sözcüksel Analiz (Lexer): Kod içerisindeki hayvanEkle, yemVer gibi anahtar kelimeleri ve sayısal değerleri tanıyarak anlamlı parçalara (Token) ayırır.

Sözdizimsel Analiz (Parser): Komutların dilin kurallarına uygunluğunu denetler ve kodun hiyerarşisini temsil eden bir Soyut Sözdizimi Ağacı (AST) oluşturur.

Anlamsal Denetim (Semantic Analysis): Yazım doğru olsa bile mantıksal hataları yakalar. Örnek: Çiftliğe hiç hayvan eklemeden "hasatYap" komutu verilirse sistem hata fırlatır.

Çalışma Ortamı (FarmEnvironment): Hayvanın ismi, açlık durumu ve sağım verileri gibi bilgileri çalışma anında (Runtime) hafızada tutar.

Gramer Yapısı (BNF/CFG)
FarmLang dilinin kuralları aşağıdaki Backus-Naur Form (BNF) yapısına uygun olarak tasarlanmıştır:

BNF
<Program>      ::= <KomutListesi>
<KomutListesi> ::= <Komut> | <Komut> <KomutListesi>
<Komut>        ::= <HayvanKomutu> | <BeslemeKomutu> | <SagimKomutu> | <HasatKomutu>

<HayvanKomutu> ::= "hayvanEkle" <Metin> ";"
<BeslemeKomutu> ::= "yemVer" <TamSayi> ";"
<SagimKomutu>   ::= "sutSag" ";"
<HasatKomutu>   ::= "hasatYap" ";"

<Metin>        ::= "\"" [a-zA-Z]+ "\""
<TamSayi>      ::= [0-9]+
Projenin Çalışma Mantığı
Proje dört temel aşamada komutları işler:

Lexer: Karakterleri HAYVAN_EKLE, NUMBER, SEMICOLON gibi birimlere ayırır.

Parser: Bu birimlerden bir ağaç yapısı kurar.

Evaluator: Ağaçtaki her bir düğümü (Node) sırasıyla ziyaret ederek karşılık gelen Java kodunu tetikler.

Sembol Tablosu: Çiftliğin o anki durumunu güncel tutar.

Kurulum ve Çalıştırma Rehberi
Projeyi kendi bilgisayarınızda test etmek için şu adımları izleyebilirsiniz:

Kodları İndirin: GitHub sayfasındaki yeşil "Code" butonuna basıp "Download ZIP" diyerek dosyaları indirin ve klasöre çıkarın.

IDE ile Açın: Eclipse veya IntelliJ gibi bir Java geliştirme ortamını açarak projeyi içeri aktarın (Import).

Main Dosyasını Bulun: src klasörü içindeki Main.java dosyasını açın.

Çalıştırın: Programı çalıştırdığınızda (Run), konsol ekranında çiftlik operasyonlarının nasıl işlendiğini ve hata yönetimini görebilirsiniz.
