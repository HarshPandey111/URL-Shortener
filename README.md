# 🔗 URL Shortener (Spring Boot + MySQL)

A simple backend URL Shortener built using **Spring Boot**, **MySQL**, and **JPA**.  
Backend REST APIs are fully functional and can be tested with tools like **Postman**. *(Frontend is optional.)*

---

## 🚀 Features

- 🔽 Shortens long URLs to tiny shortcodes
- 🔁 Redirects shortcodes to original URLs (HTTP 302)
- 💾 Stores mappings in MySQL using Spring Data JPA
- 📡 Exposes clean REST APIs for URL shortening and redirection
- 🧱 Extensible for:
  - Click tracking
  - Expiry date handling
  - Analytics
  - Frontend support

---

## 🛠️ Tech Stack

- Java 21+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- MySQL 8.x
- HikariCP (Connection Pool)
- Maven

---

## 📁 Project Structure

```
src/
 └─ main/
     ├── java/com/example/urlshortener/
     │    ├── controller/        # REST Controllers
     │    ├── model/             # JPA Entity (UrlMapping.java)
     │    ├── repository/        # Repository Interface
     │    └── service/           # Business Logic
     └── resources/
          ├── application.properties
          └── static/            # (Optional) index.html or files
```

---

## ⚙️ How to Run

### 1. 📂 Set Up MySQL Database

```sql
CREATE DATABASE urlshortenerdb;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON urlshortenerdb.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
```

---

### 2. 🧾 Configure `application.properties`

```properties
spring.application.name=urlshortener

spring.datasource.url=jdbc:mysql://localhost:3306/urlshortenerdb?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

spring.web.resources.static-locations=classpath:/static/
spring.web.resources.add-mappings=true
```

---

### 3. ▶️ Build & Run

Using Maven:

```bash
mvn clean spring-boot:run
```

Or run `UrlShortenerApplication.java` directly from your IDE.

---

## 🧪 API Endpoints (Use Postman or curl)

### ➕ Shorten a URL

- **POST**  
  `http://localhost:8080/shorten?url=https://google.com`

- **Response:**  
  `http://localhost:8080/abc123`

---

### 🔁 Redirect to Original URL

- **GET**  
  `http://localhost:8080/abc123`

- **Response:**  
  Redirect (HTTP 302) to original URL

---

### ❌ Error Handling

If short code is invalid:

```json
{
  "error": "Shortcode not found"
}
```

---

## 🗃️ Database

- **Table:** `url_mapping`
- **Fields:** `id`, `original_url`, `short_code`

Example SQL:

```sql
SELECT * FROM url_mapping;
```

---

## 🔍 Main Source Files

| File                             | Role                                      |
|----------------------------------|-------------------------------------------|
| `model/UrlMapping.java`          | Entity for URL ↔ shortcode mapping        |
| `repository/UrlMappingRepository.java` | JPA Repository with custom findByShortCode |
| `service/UrlShortenerService.java` | Contains core shortening & retrieval logic |
| `controller/UrlShortenerController.java` | REST API Controller                      |
| `controller/HomeController.java` | (Optional) Handles root `/` request        |

---

## 🌟 Optional Features (For You to Build)

- Click counter (e.g., `clickCount` field)
- Expiry logic (date/time-based link validity)
- Frontend with HTML/JS (place in `/static`)
- Custom error pages or JSON responses
- Add Spring Security for authenticated shortening

---

## 🧰 Troubleshooting

- **Static files not loading?**
  - Make sure they're in: `src/main/resources/static/`
  - Restart the app after changes
  - Check the static resource mappings in `application.properties`

---

## 📄 License

Free for educational and personal use. Attribution appreciated!
