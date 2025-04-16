# ♟ ChessGame

Ein objektorientiertes Schachspiel in Java – komplett selbst umgesetzt von Grund auf.  
Ziel war es, die **komplette Spiellogik korrekt und regelkonform** zu implementieren – inklusive Spezialregeln wie **Schach, Schachmatt, Patt, Rochade und En Passant**.

> ℹ️ Hinweis: Dies ist mein **erstes vollständiges Softwareprojekt**. Ich habe es bewusst mit Versionsverwaltung (Git + GitHub) und Dokumentation aufgebaut, um **sauberes Arbeiten in realen Projekten zu lernen und zu üben**.

---

## ✨ Features (Stand: April 2025)

### ✅ Bereits implementiert

- Alle Figurenklassen: `Bauer`, `Springer`, `Läufer`, `Turm`, `Dame`, `König`
- Vollständige Zuglogik (`isValidMove()` individuell pro Figur)
- Königsschutz: Züge, die ins eigene Schach führen, werden verhindert
- Schach-/Schachmatt-/Patt-Erkennung (regelkonform)
- En Passant (spezielle Schlagregel für Bauern)
- Rochade (kurz/lang mit allen Bedingungen)
- Farbunterscheidung per Groß-/Kleinbuchstaben (schwarz = groß, weiß = klein)
- Kompletter Ablauf über Konsole steuerbar

---

## ⚖️ Klassenstruktur (Auszug)

- `Figur` — abstrakte Oberklasse für alle Spielfiguren
- `Bauer`, `Turm`, `Springer`, `Läufer`, `Dame`, `King` — konkrete Figurenklassen
- `Brett` — enthält `Figur[][]`, Zuglogik, Königsspeicherung
- `Spiel` — Spielsteuerung inkl. Spielerwechsel, Eingabe, Spielende
- `Position1` — einfache Koordinatenklasse

---

## ▶️ Projekt ausführen (lokal)

1. Projekt mit **IntelliJ IDEA** oder einer anderen Java-IDE öffnen
2. Datei `Main.java` starten
3. Spiel startet über Konsolenausgabe (Zug-Eingabe über Text)

---

## ❌ Noch offen (optional / geplante Erweiterungen)

- Methodenkommentare und JavaDoc vervollständigen
- Wiederverwendbare Logik zentralisieren (Refactoring)

---

## 👨‍💻 Autor

- **Projekt:** ChessGame
- **Sprache:** Java
- **Status:** Abgeschlossen (Konsolen-Variante)
- **Entwickler:** Konstantin Klein
- **GitHub:** [github.com/Konsul84/ChessGame](https://github.com/Konsul84/ChessGame)

---