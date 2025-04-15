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