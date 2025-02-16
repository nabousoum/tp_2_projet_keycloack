Projet Keycloak avec Spring Boot

Un projet Spring Boot pour gérer l'authentification et l'autorisation avec Keycloak, ainsi que des opérations ajout et liste sur des produits.


Prérequis

- Java 17 ou supérieur
- Maven 3.8+
- MySQL (ou toute autre base compatible avec JPA)
- Keycloak 22+
- Postman(pour tester les endpoints API)


Installation et configuration


 1. Configurer Keycloak

- Démarrer Keycloak :
  bin\kc.bat start-dev
- Créer un realm : 'projet2_keycloack'.
- Ajouter un client nommé 'projet2_keycloack-realm' avec :
- Ajouter un utilisateur (ex. 'nabousoum') et lui attribuer des rôles ('realm-user').


 2. Configurer la base de données

Créez une base de données MySQL :

sql
CREATE DATABASE db_project_keycloack;

Mettez à jour le fichier 'application.properties' avec vos identifiants :

properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_project_keycloack
spring.datasource.username=root
spring.datasource.password=yourpassword


 3. Configurer Keycloak dans Spring Boot

Dans application.properties, configurez Keycloak :


4. Lancer l'application


API Endpoints
`GET`    ->   `/products`       : Liste tous les produits                    
 `POST`    ->  `/products`         : Ajoute un nouveau produit                     

Tester avec Postman

1. Obtenir un token Keycloak

- URL: POST http://localhost:8080/realms/projet2_keycloack/protocol/openid-connect/token
  - Body (x-www-form-urlencoded) :
  - `grant_type` : `password`
  - `client_id` : `projet2_keycloack-realm`
  - `username` : `nabousoum`
  - `password` : `yourpassword`

Copiez le `access_token` reçu.

#2. Utiliser l'API

- GET /products :
  - Authorization : Bearer Token (votre `access_token`)

- POST /products :
  - Headers :
    - `Content-Type` : `application/json`
  - Body (JSON) :
    ```json
    {
      "name": "MacBook Pro"
    }
    ```


Structure du projet

src
│
├── main
│   ├── java/com/dev/project_keycloack
│   │   ├── config       -> Configurations Spring Security
│   │   ├── controllers  -> Contrôleurs REST
│   │   ├── entities     -> Entités JPA
│   │   ├── repositories -> Repositories JPA
│   │   ├── services     -> Services métiers
│   │
│   └── resources
│       ├── templates    -> Fichiers Thymeleaf
│       ├── application.properties
│
└── test


Captures
![Screenshot 2025-02-16 014009](https://github.com/user-attachments/assets/3ecf73c3-e159-46dc-ae33-e289e7ccc18c)

![Screenshot 2025-02-16 014041](https://github.com/user-attachments/assets/50a5694e-64a3-4fb6-af56-134b041d0b55)

![Screenshot 2025-02-16 014054](https://github.com/user-attachments/assets/6afa5512-0278-4f6b-9ed0-b72ca6b2c157)

Ressources utiles

- [Documentation Keycloak](https://www.keycloak.org/documentation)
- [Spring Security OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)


Auteur

👤 Seynabou SOUMARE 
📧 seynabou@groupeisi.com 
