# AsyncEmailSender

## Proje Açıklaması

Bu proje, rastgele seçilen alıcılara (e-postalara), rastgele konu ve içerik ile e-postalar göndermek için geliştirilmiş bir Java uygulamasıdır. Uygulama, MongoDB kullanarak email veritabanındaki "emailCollection" ve "subjectContentCollection" koleksiyonlarını kullanır.

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

<hr>

# AsyncEmailSender

## Project Description

This project is a Java application for sending emails to randomly selected recipients (emails) with random subject and content. The application uses “emailCollection” and “subjectContentCollection” collections from the email database using MongoDB.

## Technologies

**Programming Language:** Java

**Email Sending:** Jakarta Mail API

**Database:** MongoDB

**Addiction Management:** Maven

**Environmental Variable Management:** Dotenv

## Usage

**1. Requirements**

* Java 8 or above

* MongoDB

* An email account with SMTP support (e.g. Gmail)

**2. Installation**

* Clone the project:

git clone <repository-link>
cd async-email-sender

* Use Maven to install the required dependencies:

mvn clean install

* Make sure that MongoDB is working correctly. Create your collections according to the following schema:

emailCollection Schema

{
  “_id": “ObjectId”,
  “email": “String”
}

subjectContentCollection Schema

{
  “_id": “ObjectId”,
  “subject": “String”,
  “content": “String”
}

* Define email credentials in an .env file:

EMAIL_USERNAME=ornek@gmail.com
EMAIL_PASSWORD=example_password

**Note:** For security reasons the .env file will not be uploaded to GitHub. The username and password for your email account are stored here. The project will not run without this file.

* Run the application:

mvn exec:java
