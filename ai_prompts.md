📅 10 Mayıs 2026: Dil Tasarımı ve Gramer (EBNF) Kurgusu
Prompt: "Java üzerinde çalışacak, tarım ve çiftlik temalı 'FarmLang' adında basit bir dil tasarlıyorum. hayvanEkle, yemVer gibi komutlarım olacak. Bu dilin dilbilgisi kurallarını (EBNF) akademik bir dille nasıl tanımlayabilirim?"

Süreç: Yapay zekanın önerdiği gramer yapısı temel alınarak FarmLang'in komut dizilimi belirlendi. Her satırın noktalı virgül (;) ile bitmesi kuralı netleştirildi. Dilin esnekliğini artırmak için komutların yanına parametre (isim veya sayı) ekleme mantığı kurgulandı.

📅 11 Mayıs 2026: Lexer ve Tokenizasyon Mantığı
Prompt: "FarmLang'deki komutları (keywords), isimleri (identifiers) ve sayıları (numbers) birbirinden ayıracak bir Lexer yapısı kurmak istiyorum. Java'da Token sınıfı içinde hangi özellikleri tutmalıyım ki Parser aşamasında kolayca kullanabileyim?"

Süreç: AI tarafından önerilen TokenType enum yapısı projeye dahil edildi. Lexer.java içinde metni parçalara ayıran (tokenizing) algoritmada, tırnak içindeki hayvan isimlerini doğru tanıyabilmesi için gerekli RegEx güncellemeleri tarafımdan yapıldı.

📅 12 Mayıs 2026: Parser Hiyerarşisi ve Syntax Hataları
Prompt: "Parser sınıfında 'hayvanEkle' komutundan sonra bir string gelmediğinde veya noktalı virgül unutulduğunda programın durup anlamlı bir 'Syntax Error' vermesini nasıl sağlarım? ASTNode yapısı bu hataları yakalamada nasıl kullanılır?"

Süreç: Recursive Descent Parser metodolojisi üzerine teknik destek alındı. Beklenen bir token gelmediğinde fırlatılacak özel hata mesajları yapılandırıldı. Parser'ın başarılı olduğu durumlarda oluşturduğu Soyut Sözdizim Ağacı (AST) yapısı ASTNode.java üzerinden kurgulandı.

📅 13 Mayıs 2026: Evaluator (Çalıştırma) ve Hafıza (Environment)
Prompt: "FarmLang'de hayvanların durumunu ve yem miktarlarını program çalıştığı sürece hafızada nasıl tutabilirim? Environment sınıfında bir HashMap kullanmak mantıklı mı? Ayrıca projenin ispatı için hangi test senaryolarını hazırlamalıyım?"

Süreç: Programın hafızası olarak görev yapacak olan Environment.java sınıfı, AI'nın önerdiği anahtar-değer (Key-Value) eşleşmesiyle tasarlandı. Projenin doğruluğunu kanıtlamak adına; başarılı ekleme, hatalı yazım ve geçersiz işlem senaryoları oluşturularak test edildi.📅 13.05.2026 - Dilin Gramer Yapısının Formalize Edilmesi
Prompt (Soru):

"Kendi tasarladığım ve çiftlik operasyonlarını yöneten 'FarmLang' isimli dil için BNF (Backus-Naur Form) kurallarını oluşturmak istiyorum. hayvanEkle, yemVer, sutSag ve hasatYap gibi komutların standart derleyici kurallarına uygun bir şablonunu paylaşır mısın?"

Alınan Destek ve Uygulama:

Dilin kurallarını hiyerarşik bir yapıda gösteren BNF şablonu alındı.

Bu şablon, projenin README.md dosyasındaki teknik dökümantasyon kısmına uyarlandı ve dilin sınırlarını belirlemek için kullanıldı.

📅 13.05.2026 - Parser Mantığı ve Karakter Okuma Optimizasyonu
Prompt (Soru):

"Java ile yazdığım Lexer'da kullanıcıdan gelen metinleri (String) ve sayıları (Number) okurken bazen sonsuz döngüye giriyorum. pos++ mantığını ve while döngüsünü daha güvenli hale getirmek için nasıl bir yapı kurmalıyım?"

Alınan Destek ve Uygulama:

Lexer.java içerisinde karakterleri tek tek kontrol ederken imlecin (pointer) her durumda ilerlemesini sağlayan döngü yapısı revize edildi.

Bilinmeyen bir komut girildiğinde fırlatılacak olan RuntimeException hata mesajları daha bilgilendirici hale getirildi.

📅 13.05.2026 - Anlamsal Analiz (Semantic Analysis) Tasarımı
Prompt (Soru):

"Yazdığım dilde bir mantık kontrolü yapmak istiyorum. Eğer kullanıcı hayvanEkle komutunu kullanmadan hasatYap komutunu yazarsa sistem hata vermeli. Bu tarz bir kontrolü Parser katmanında mı yoksa Evaluator katmanında mı yapmalıyım?"

Alınan Destek ve Uygulama:

Bu tür mantıksal denetimlerin "Anlamsal Analiz" olduğu ve FarmEnvironment (çalışma ortamı) içerisinde yapılmasının daha doğru olacağı bilgisi alındı.

Projedeki FarmEnvironment sınıfına bir currentAnimal kontrolü eklenerek, boş olması durumunda hata fırlatılması sağlandı.

📅 13.05.2026 - Akademik Dökümantasyon ve README Düzenleme
Prompt (Soru):

"Hocanın istediği tüm kriterleri (kurulum, özellikler, gramer) içeren profesyonel bir README dosyası taslağı oluşturur musun? Kurulum adımları son kullanıcı (veya hoca) için çok sade ve anlaşılır olmalı."

Alınan Destek ve Uygulama:

Dökümantasyonun ana başlıkları ve projenin teknik katmanlarını (Lexer, Parser, AST) açıklayan kısımlar yapay zeka önerileriyle yapılandırıldı.

Kurulum rehberi, terminal komutlarından arındırılarak Eclipse/IDE üzerinden yapılacak şekilde Türkçeleştirildi ve sadeleştirildi.
