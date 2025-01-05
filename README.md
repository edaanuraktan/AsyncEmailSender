# AsyncEmailSender

## Proje Açıklaması

Bu proje, rastgele seçilen alıcılara (e-postalara), rastgele konu ve içerik ile e-postalar göndermek için geliştirilmiş bir Java uygulamasıdır. Uygulama, MongoDB kullanarak email veritabanındaki "emailCollection" ve "subjectContentCollection" koleksiyonlarını kullanır.

## Genel İşleyiş

* emailCollection koleksiyonundan rastgele 10 e-posta adresi seçilir.

* subjectContentCollection koleksiyonundan rastgele bir konu ve içerik seçilir.

* Her bir e-posta adresine rastgele seçilen konu ve içerik ile e-posta gönderilir.

* Projede çoklu iş parçacığı (multithreading) kullanılarak e-postalar eşzamanlı olarak gönderilir.

## Teknolojiler

**Programlama Dili:** Java

**E-posta Gönderimi:** Jakarta Mail API

**Veritabanı:** MongoDB

**Bağımlılık Yönetimi:** Maven

**Çevresel Değişken Yönetimi:** Dotenv

## Kullanım

**1. Gereksinimler**

* Java 8 veya üzeri

* MongoDB

* SMTP destekli bir e-posta hesabı (Örneğin Gmail)

**2. Kurulum**

* Projeyi klonlayın:

git clone <repository-link>
cd async-email-sender

* Gerekli bağımlılıkları yüklemek için Maven kullanın:

mvn clean install

* MongoDB'nin doğru şekilde çalıştığından emin olun. Aşağıdaki şemaya uygun koleksiyonlarınızı oluşturun:

emailCollection Şeması

{
  "_id": "ObjectId",
  "email": "String"
}

subjectContentCollection Şeması

{
  "_id": "ObjectId",
  "subject": "String",
  "content": "String"
}

* E-posta kimlik bilgilerini bir .env dosyasında tanımlayın:

EMAIL_USERNAME=ornek@gmail.com
EMAIL_PASSWORD=ornek_sifre

**Not:** Güvenlik sebeplerinden dolayı .env dosyası GitHub'a yüklenmeyecektir. E-posta hesabınızın kullanıcı adı ve şifresi burada saklanır. Bu dosya olmadan proje çalışmaz.

* Uygulamayı çalıştırın:

mvn exec:java

## Proje Dosya Yapısı

**AsyncEmailSender.java:** Uygulamanın ana dosyası. E-posta işleme işlevini başlatır.

**DatabaseConnector.java:** MongoDB ile bağlantı sağlar.

**EmailSender.java:** E-posta gönderim işlemlerini yürütür.

**EmailWorker.java:** Veritabanından rastgele e-posta adresi ve içerik seçer ve e-posta gönderimini eşzamanlı olarak gerçekleştirir.

**.env:** E-posta kullanıcı adı ve şifresi gibi hassas bilgileri saklar. 


