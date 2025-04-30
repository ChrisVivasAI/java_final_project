# 🎾 Tennis Tournament Management System

This is the final project for the **Programming with Java** course. It is a complete RESTful API developed using **Java**, **Spring Boot**, and **Maven**, designed to manage players, tournaments, match results, and player rankings.

---

## 🧠 Project Overview

This backend system simulates the core logic of a tennis tournament:

- ✅ Players can be created, updated, and removed
- ✅ Tournaments can be created and populated with registered players
- ✅ Matches between players can be recorded with scores and winners
- ✅ Player statistics (wins/losses) are automatically updated
- ✅ A dynamic **ranking system** returns players sorted by their number of wins

All data is stored in-memory using the **H2 database** for simplicity and testing.

---

## 🛠️ Key Features

### 🔹 Players
- `POST /players` — Create a new player (requires name, age, wins, losses)
- `GET /players` — Retrieve all players
- `GET /players/{id}` — View details of a single player
- `PUT /players/{id}` — Update player information
- `DELETE /players/{id}` — Remove a player

### 🔹 Tournaments
- `POST /tournaments` — Create a tournament with name, location, start/end dates
- `GET /tournaments` — View all tournaments
- `POST /tournaments/{id}/players/{playerId}` — Register a player to a tournament

### 🔹 Matches
- `POST /matches` — Record a match using a JSON payload with:
    - player1Id, player2Id, winnerId, tournamentId, matchDate, score
- `GET /matches/{id}` — Retrieve the details of a recorded match

### 🔹 Rankings
- `GET /rankings` — View all players ranked by the number of wins (descending order)

---

## 📚 Technologies Used
- Java 17
- Spring Boot 3
- Spring Data JPA
- Maven
- H2 In-Memory Database
- Jakarta Validation (for input checks)

---

## ✅ Status
This project is fully functional and meets the course requirements for the **Programming with Java** final assignment. It includes:
- Clean architecture (DTO usage for inputs)
- Validation of all input data
- Modular service layers
- Fully working endpoints tested with Postman

---

## 🙌 Acknowledgments
This project was built as part of the **Programming with Java** course curriculum and reflects concepts learned throughout the semester, including:
- Object-oriented design
- REST API development
- MVC pattern
- Data persistence and validation
