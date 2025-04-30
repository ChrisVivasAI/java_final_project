# 🎾 Tennis Tournament Backend API (Spring Boot)

This is a Spring Boot RESTful API for managing tennis tournaments, players, matches, and player rankings.

## 📦 Features

- Register players and tournaments
- Register players to tournaments
- Record match results
- Retrieve match data
- Get player rankings sorted by wins

---

## 🔧 Technologies

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 In-Memory Database
- Postman for API testing

---

## 🧪 API Endpoints

| Endpoint              | Method | Description                  |
|-----------------------|--------|------------------------------|
| `/players`            | POST   | Create a player              |
| `/tournaments`        | POST   | Create a tournament          |
| `/tournaments/{id}/register/{playerId}` | POST | Register a player to a tournament |
| `/matches/record`     | POST   | Record a match               |
| `/matches/{id}`       | GET    | Get match by ID              |
| `/matches`            | GET    | List all matches             |
| `/rankings`           | GET    | Get player rankings by wins  |

---

## 📸 Example Match Payload

```json
{
"player1Id": 1,
"player2Id": 2,
"winnerId": 1,
"tournamentId": 5,
"matchDate": "2025-05-01",
"score": "6-4, 7-5"
}

```

👨‍💻 Author
@ChrisVivasAI