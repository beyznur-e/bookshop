Online Kitap Satış Platformu

Proje Açıklaması

Bu proje, bir online kitap satış platformu olarak geliştirilmiştir. Kullanıcılar kitapları arayabilir, sepete ekleyebilir ve sipariş verebilir. Yöneticiler ise kitap ve sipariş yönetimi yapabilir.

Özellikler

Kullanıcı Paneli

Kullanıcı kayıt ve girişi

Kitap arama 

Sepete kitap ekleme, listeleme ve silme

Sipariş verme 

Kurulum

Gereksinimler

Java 17 veya daha üstü

Maven 3.6+

PostgreSQL 

Kurulum Adımları

Projeyi klonlayın:

git clone https://github.com/beyznur-e/bookshop.git

Bağımlılıkları yükleyin:

mvn clean install

Veritabanı bağlantı ayarlarını update edin: src/main/resources/application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/bookshop
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update

Uygulamayı çalıştırın:

mvn spring-boot:run

Kullanım

Swagger Arayüzü

Önemli API Endpointleri

Kullanıcı İşlemleri

POST /api/auth/register - Kullanıcı kaydı

POST /api/auth/login - Kullanıcı girişi

Kitap İşlemleri

GET /api/book/list - Tüm kitapları listeleme

Sepet İşlemleri

POST /api/cart - Sepete kitap ekleme

Sipariş İşlemleri

POST /api/orders - Sipariş oluşturma
