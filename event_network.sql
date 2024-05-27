CREATE TABLE event (
    id SERIAL PRIMARY KEY,
	macro VARCHAR(255),
    tipologia VARCHAR(255),
    url_image VARCHAR(255),
    eventname VARCHAR(255),
    organizzatore VARCHAR(255),
    sponsor BOOLEAN,
    luogo VARCHAR(255),
    data VARCHAR(255),
    descrizione VARCHAR(255)
);


INSERT INTO event (macro, tipologia, url_image, eventname, organizzatore, sponsor, luogo, data, descrizione)
VALUES 
('Musica','Jazz','./immagini/jazz_concert.png', 'Concerto di Jazz', 'MusicEvents', false, 'Teatro XYZ', '2024-06-10', 'Serata di jazz con artisti internazionali.'),
('Sport', 'Basket', './immagini/basket_match.png', 'Partita di Basket', 'SportClub', false, 'Palazzetto dello Sport', '2024-05-25', 'Partita di basket tra squadre di serie A.'),
('Cinema', 'Commedia', './immagini/cinema.png', 'Una risata vi seppellirà', 'CineTeatro', false, 'Roma', '2024-05-16', 'Serata comica con i migliori film di sempre.'),
('Teatro', 'Drammatico','./immagini/romeogiulietta.png', 'Romeo e Giulietta', 'GranTeatro', true, 'Milano', '2024-06-05', 'Interpretazione classica della famosa tragedia di Shakespeare.'),
('Musica','Pop','./immagini/pop_concert.png', 'Concerto Pop', 'MusicEvents', true, 'Arena di Verona', '2024-07-20', 'Concerto pop con le migliori star del momento.'),
('Sport', 'Calcio', './immagini/soccer_match.png', 'Partita di Calcio', 'SportClub', true, 'Stadio Olimpico', '2024-05-30', 'Partita di calcio tra squadre di Serie A.'),
('Cinema', 'Fantascienza', './immagini/cinema1.png', 'Viaggio nel futuro', 'CineTeatro', true, 'Milano', '2024-06-15', 'Una serata di fantascienza con i migliori film del genere.'),
('Teatro', 'Musicale','./immagini/teatro.png', 'Il Fantasma dell''Opera', 'GranTeatro', true, 'Roma', '2024-07-10', 'Lo spettacolo musicale che ha incantato il mondo intero.'),
('Musica','Rock','./immagini/rock_concert.png', 'Concerto Rock', 'MusicEvents', true, 'Stadio San Siro', '2024-06-25', 'Serata di rock con le leggende del genere.'),
('Sport', 'Atletica', './immagini/athletics_event.png', 'Meeting di Atletica', 'SportClub', false, 'Stadio delle Rose', '2024-06-15', 'Evento di atletica con i migliori atleti internazionali.'),
('Cinema', 'Drammatico', './immagini/cinema1.png', 'La lista di Schindler', 'CineTeatro', false, 'Napoli', '2024-07-05', 'Capolavoro drammatico di Steven Spielberg.'),
('Teatro', 'Commedia','./immagini/commediateatro.png', 'Il Servitore di due padroni', 'GranTeatro', true, 'Firenze', '2024-06-20', 'Commedia brillante di Carlo Goldoni.'),
('Musica','Classica','./immagini/classical_concert.png', 'Concerto Classico', 'MusicEvents', true, 'Teatro alla Scala', '2024-07-15', 'Serata di musica classica con i migliori artisti internazionali.'),
('Sport', 'Tennis', './immagini/tennis_match.png', 'Torneo di Tennis', 'SportClub', false, 'Foro Italico', '2024-06-30', 'Torneo di tennis con i migliori giocatori del mondo.'),
('Musica','Pop','./immagini/concprim.png', 'Concerto di Primavera', 'MusicStore', true, 'Teatro XYZ', '2024-05-15', 'Concerto di primavera con artisti famosi.'),
('Sport', 'Calcio', './immagini/napolijuve.png', 'Napoli-Juventus', 'SportClub', true, 'Stadio ABC', '2024-05-20', 'Partita di campionato.'),
('Cinema', 'Horror', './immagini/cinema.png', 'L''esorcista', 'CineTeatro', true, 'Roma', '16/05/2024', 'Terrificante nottata all''insegna dell''horror.'),
('Teatro', 'Commedia','./immagini/teatro.png', 'Divina Commedia', 'GranTeatro', false, 'Milano', '10/07/2026', 'Grandiosa interpretazione della Divina Commedia in chiave moderna.');
