♟ ChessGame

Ein objektorientiertes Schachspiel in Java. Ziel ist es, die komplette Spiellogik korrekt umzusetzen, inklusive Zugprüfung, Schach-/Schachmatt-Erkennung und späterer Erweiterung um eine GUI.

Hinweis: Diese README wurde mithilfe von KI erstellt und anschließend manuell angepasst.

✨ Features (Stand: aktuell)

✅ Bereits implementiert

Vollständige Figurenklassen: Turm, Läufer, Springer, Dame, König, Bauer

Objektorientierte Struktur mit Vererbung für Figur

isValidMove() implementiert für alle Figuren

Königsschutz: isMyKingNotCheck(Position1, figurs) verhindert ungültige Züge

Schacherkennung: isEnemyKingChecked(...) erkennt, ob der Gegner im Schach steht

Initiale Brettaufstellung mit richtiger Positionierung aller Figuren

Farbunterscheidung per Klein-/Großbuchstabe (weiß = klein, schwarz = groß)

❌ Noch nicht implementiert / in Arbeit

En Passant für Bauern

Rochade (inkl. Bedingungen: Turm und König nicht bewegt, keine Schachstellung)

Vollständige Schachmatt- und Patt-Erkennung

GUI (z. B. mit JavaFX oder Swing)

Zug-Historie und Rücknahmefunktion (Undo)

Zeitkontrolle, Spielzüge anzeigen, Mehrspielermodus

⚖️ Klassenstruktur (Auszug)

Figur — abstrakte Oberklasse aller Figuren

Turm, Läufer, Springer, Dame, King, Bauer — konkrete Spielfiguren mit eigener isValidMove()-Logik

Brett — Spielbrett mit Figur[][] figurs, Initialisierung & Zugriff auf whiteKing / blackKing

Spiel — Hauptspielsteuerung, erkennt Schach/Schachmatt (teilweise vorbereitet)

Position1 — einfache Wrapperklasse für Koordinaten

🔄 Geplante Erweiterungen



▶️ Projekt ausführen (lokal)

Projekt in IntelliJ IDEA öffnen

Main.java ausführen

Züge aktuell über Konsolenausgabe/Tests sichtbar

👨‍💻 Autor

Projekt: ChessGame

Sprache: Java

Erstes größeres Projekt von: Konstantin Klein

GitHub: https://github.com/Konsul84/ChessGame