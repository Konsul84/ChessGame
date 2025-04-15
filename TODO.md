# TODO – ChessGame (Minimaler Umfang zum Fertigstellen)

## ♟️ Spiellogik (Pflicht)

- [x] Alle Figurenklassen mit `isValidMove()` implementiert
- [x] König darf sich nicht ins Schach bewegen (`isMyKingNotCheck(...)`)
- [x] Gegner-Schachprüfung nach Zug (gegnerischer König bedroht)
- [ ] Patt-Erkennung (keine legalen Züge + König **nicht** im Schach)
- [ ] Schachmatt-Erkennung (keine legalen Züge + König **im** Schach)
- [ ] En Passant (optional → falls einfach umsetzbar)
- [ ] Rochade mit Bedingungen (König + Turm nicht bewegt, kein Schachfeld überschritten)

## 🧠 Code-Struktur & Sauberkeit

- [x] `whiteKing` und `blackKing` in `Brett` von `static` zu Instanzvariablen gemacht
- [x] Zugriff auf König über Brett-Referenz in `Figur`
- [x] Gegner-Schachprüfung aus `isMyKingNotCheck(...)` entfernt
- [ ] `movePiece(...)` strukturell verbessern → Nur Spiellogik dort, keine Logikverzweigungen
- [ ] Methoden dokumentieren / auskommentieren (besonders: `isValidMove()`, `isMyKingNotCheck()`)
- [ ] Doppelte/ähnliche Logik zentralisieren, wo sinnvoll

## 🧪 Spielabschluss prüfen

- [ ] Methode schreiben: `hasAnyLegalMove(FigurFarbe)` zur Prüfung auf Patt oder Matt
- [ ] Bei jedem Zug prüfen, ob das Spiel zu Ende ist
- [ ] Klarer Spielausgang: Schachmatt, Patt, Aufgabe (Konsolenausgabe reicht)

## 🧹 Aufräumen

- [ ] Unbenutzte Methoden entfernen (`isEnemyKingChecked`, wenn nicht genutzt)
- [ ] Debug-Ausgaben durch sinnvolle `System.out.println(...)` ersetzen
- [ ] README.md finalisieren mit kurzer Anleitung + Übersicht

- [ ] ➡️ Aktuelles Ziel: **Funktionierendes, testbares, sauberes Konsolen-Schachspiel** ✅

TODO.md erstellt mit ChatGPT
