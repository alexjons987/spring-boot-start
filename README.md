# spring-boot-start
Intro assignment for Spring Boot

## Excercises
### 🔹 **Exercise 1 – Start your first Spring Boot project**

**Goals:** Understand the structure of a Spring Boot project.

1. Go to [https://start.spring.io](https://start.spring.io)

* Project: *Maven Project*
* Language: *Java*
* Spring Boot: 3.5.7 (latest stable)
* Group: `com.example`
* Artifact: `hello-spring`
* Dependencies: `Spring Web`
* Packaging: Jar
* Configuration: Properties
* Java: 17

2. Download the project and open it in **IntelliJ**.

3. Run the application.

4. Check in the terminal that the server has started on **port 8080**.

5. Open the browser and go to:

```
http://localhost:8080
```

What happens?

(Hint: no endpoint yet – you’ll create one in the next exercise!)

---

### 🔹 **Exercise 2 – Create your first REST controller**

**Goals:** Learn how Spring maps URLs to methods with annotations.

1. Create a new class in the `com.example.hellospring` package:

```java
package com.example.hellospring;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@GetMapping("/hello")
public String sayHello() {
return "Hello Spring Boot!";
}
}
```

2. Run the application again.

3. Go to:

```
http://localhost:8080/hello
```

4. What does the browser display?

5. Try changing the text in the return value and see the result.

📘 **Extra:**
Create another method in the same class, e.g.

```java
@GetMapping("/bye")
public String sayBye() {
return "Goodbye Spring!";
}
```

---

### 🔹 **Exercise 3 – Return JSON data**

**Goals:** Understand that Spring Boot automatically converts objects to JSON.

1. Create a new class `Greeting` in the same package:

```java
public record Greeting(String message, int id) {}
```
2. In `HelloController`, add:

```java
@GetMapping("/greeting")
public Greeting greeting() {
return new Greeting("Welcome to Spring Boot!", 1);
}
```
3. Run the application and test:

```
http://localhost:8080/greeting
```
4. What do you get back in the browser?
(Should be JSON, e.g. `{ "message": "Welcome to Spring Boot!", "id": 1 }`)

💡 **Think:** Why didn't we have to write any code to convert the object to JSON?

---

### 🔹 **Exercise 4 – Create your own controller**

**Goal:** Independently create a new controller with your own endpoints.

1. Create a new class, e.g. `InfoController`:

```java
@RestController
public class InfoController {

@GetMapping("/info")
public String info() {
return "Spring Boot makes Java web apps easy!";
}
}
```

2. Add another endpoint that returns an object, e.g.:

```java
public record Course(String name, String teacher) {}

@GetMapping("/course")
public Course course() {
return new Course("Java in-depth", "Your teacher");
}
```

3. Test both endpoints in the browser or in Postman.

📘 **Extra:**
Create an endpoint `/time` that returns the current time:

```java
@GetMapping("/time")
public String currentTime() {
return LocalDateTime.now().toString();
}
```

---

### Reflection and discussion

**Goals:** Understand what Spring Boot does behind the scenes.

Discuss in small groups:

1. What makes Spring Boot different from regular Java programs with `main()`?
2. How does Spring know which method to call when visiting `/hello`?
3. What happens if you have two methods with the same `@GetMapping`?
4. What does `@RestController` actually mean?