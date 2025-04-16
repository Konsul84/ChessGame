## [2025-04-15]

- Refactored: `whiteKing` und `blackKing` in `Brett` von `static` zu Instanzvariablen gemacht
- Zugriff auf Könige jetzt über Brett-Referenz statt global
- Vorbereitung auf bessere OOP-Struktur 

### 🎯 Spiellogik & Spielfluss

- Fehler in `King.isPositionSafe()` behoben (gab fälschlich `false` bei sicheren Feldern) → führte zu Schachmatt direkt beim Spielstart
- `isMyKingNotCheck()` aufgeräumt → keine Seiteneffekte mehr
- Schachmatt- und Patt-Erkennung am Rundenanfang korrekt integriert
- `hasNoValidMoves()` vollständig implementiert zur Endspiel-Erkennung

### 🧹 Aufräumarbeiten

- `isEnemyKingChecked(...)` entfernt (nicht mehr verwendet)
- `printSpielFeld()` modernisiert mit ASCII-Zeichen (z. B. `░` für dunkle Felder)

---

✅ Status: Grundspiel ist fertig & spielbar über Konsole (ohne GUI)
➡️ Nächster Meilenstein: Methodenkommentare & optional En Passant / Rochade

## [2025-04-16]

### ♟ Spiellogik & Regeln

- ✅ **En Passant** korrekt implementiert:
    - Nur direkt im Folgezug des gegnerischen Doppelzugs möglich
    - Rücksetzung des En-Passant-Zustands nach jedem Zug
    - Entfernt geschlagenen Bauern zuverlässig
- ✅ **Rochade** umgesetzt (kurz & lang):
    - Bedingungen wie "nicht im Schach", "Turm/König nicht gezogen", "freie Felder" geprüft
    - Turm und König werden korrekt versetzt und `notMoved` aktualisiert
- ✅ Fehlerbehebung: `King.isPositionSafe()` prüft keine gegnerischen Könige mehr → verhindert StackOverflow durch gegenseitige Aufrufe
- Kommentarstruktur in `movePiece()` verbessert (ohne Logikänderung)

### 🧹 Aufräumarbeiten

- En Passant Logik in `movePiece()` sauber gekapselt
- Rochade sauber in `isValidMove()` + `movePiece()` integriert
- Kommentare vereinheitlicht und Code strukturell geglättet

---

✅ Status: Spiellogik **vollständig funktional**, inkl. En Passant & Rochade  
📌 Nächster Schritt: Methoden kommentieren + Testabdeckung erweitern




Changelog erstellt mit ChatGPT
