#  GymTracker Backend

Spring Boot REST API zum Tracken von Workouts, Sets und Übungen.  
Entwickelt als Lern- und Showcase-Projekt für Backend, Security und Deployment.

---

## 🚧 Status
Dieses Projekt befindet sich noch **in einer sehr frühen Anfangsphase**.  
Aktuell existiert das Backend als API – ein externes Frontend (React) wird später angebunden.

👉 Live-Version: [GymTracker Backend – Render](https://gymtracker-backend-zurk.onrender.com) *(wird bald auf einen anderen Server umgezogen)*

---

## 🚀 Features
- User-Registrierung & Login (JWT Authentication)  
  *(eingeschränkt, da kostenlose Server wenig Rechenpower haben)*
- Rollen & Berechtigungen (`USER`, `ADMIN`)
- CRUD für Workouts, Exercises, Sets
- Seed-Funktion für initialen Admin (nur wenn aktiviert)
- Sauberes Projekt-Setup mit Gradle & Docker

---

##  Tech-Stack
- **Spring Boot** (REST, Data JPA, Security)
- **PostgreSQL** (Prod/Dev via Docker)
- **Gradle** Build
- **JWT** Authentication
- **BCrypt** für Passwort-Hashing
- **Docker** + `.env` Konfiguration

---

##  Setup

### 1. Repository klonen
```bash
git clone https://github.com/Pavaea/gymtracker-backend.git
cd gymtracker-backend
