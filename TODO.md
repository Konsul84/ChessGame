# TODO – ChessGame

## ♟️ Spiellogik

- [x] Alle Figurenklassen mit `isValidMove()` implementieren
- [x] König darf sich nicht ins Schach bewegen (`isMyKingNotCheck(...)`)
- [x] Gegner-Schachprüfung nach Zug (gegnerischer König bedroht)
- [ ] Patt-Erkennung (keine legalen Züge + König **nicht** im Schach)
- [ ] Schachmatt-Erkennung (keine legalen Züge + König **im** Schach)
- [ ] En Passant (nur direkt nach gegnerischem Doppelzug erlaubt)
- [ ] Rochade (König + Turm nicht bewegt, kein Schachfeld überschritten)

## 🧠 Architektur & Struktur

- [x] `whiteKing` und `blackKing` in `Brett` von `static` auf Instanzfelder geändert
- [x] Zugriff auf König über Brett-Referenz in `Figur`
- [ ] Gegner-Schachprüfung aus `isMyKingNotCheck(...)` herauslösen  
  → Logik gehört in `movePiece()` oder `Spiel`, nicht in `Figur`
- [ ] Methodenstruktur verbessern: keine Zustandsänderung in Prüfmethoden
- [ ] Figur-Referenzierung besser kapseln (`getFigurAt(Position1)`?)
- [ ] Überprüfung ob König bedroht ist in eigene Utility-Logik auslagern

## 💻 Oberfläche (später)

- [ ] Konsoleneingabe für Züge ermöglichen (`e2 -> e4`)
- [ ] GUI mit Swing oder JavaFX (Spielfeld, Figuren, Highlighting)
- [ ] Darstellung von Schach/Schachmatt-Status im Spiel

## 📈 Features / Erweiterung

- [ ] Undo-Funktion / Zug-Historie speichern
- [ ] Spielstände speichern / laden
- [ ] Zugtimer / Zeitanzeige

## 🤖 KI (optional)

- [ ] Einfacher Random-Bot
- [ ] Minimax-basierter Gegner mit Bewertung von Zügen

## 🧪 Tests & Sicherheit

- [ ] Unit-Tests für `isValidMove()` jeder Figur
- [ ] Tests für Schachmatt- und Patt-Erkennung
- [ ] Fehlerbehandlung bei ungültigen Zügen


TOTO.md Mit chatGPT erstellt
